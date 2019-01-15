package com.mycompany.springbootelasticgymactivities.controller;

import com.mycompany.springbootelasticgymactivities.dto.CreateActivityDto;
import com.mycompany.springbootelasticgymactivities.dto.UpdateActivityDto;
import com.mycompany.springbootelasticgymactivities.exception.ActivityNotFoundException;
import com.mycompany.springbootelasticgymactivities.model.Activity;
import com.mycompany.springbootelasticgymactivities.service.ActivityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ma.glasnost.orika.MapperFacade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    private final ActivityService activityService;
    private final MapperFacade mapperFacade;

    public ActivityController(ActivityService activityService, MapperFacade mapperFacade) {
        this.activityService = activityService;
        this.mapperFacade = mapperFacade;
    }

    @ApiOperation(value = "Create Activity", code = 201)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public Activity createActivity(@Valid @RequestBody CreateActivityDto createActivityDto) {
        Activity activity = mapperFacade.map(createActivityDto, Activity.class);
        return activityService.save(activity);
    }

    @ApiOperation(value = "Delete Activity")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public String deleteActivity(@PathVariable String id) {
        Activity activity = activityService.getActivityById(id);
        activityService.delete(activity);
        return id;
    }

    @ApiOperation(value = "Update Activity")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Activity updateActivity(@PathVariable String id, @Valid @RequestBody UpdateActivityDto updateActivityDto)
        throws ActivityNotFoundException {
        Activity activity = activityService.getActivityById(id);
        mapperFacade.map(updateActivityDto, activity);
        return activityService.save(activity);
    }

    @ApiOperation(
        value = "Get Activities",
        notes = "To sort the results by a specified field, use in 'sort' field a string like: fieldname,[asc|desc]")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Page<Activity> getProducts(Pageable pageable) {
        return activityService.listActivitiesByPage(pageable);
    }

    @ApiOperation(value = "Get Activity")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Not Found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Activity getProduct(@PathVariable String id) throws ActivityNotFoundException {
        return activityService.getActivityById(id);
    }
}
