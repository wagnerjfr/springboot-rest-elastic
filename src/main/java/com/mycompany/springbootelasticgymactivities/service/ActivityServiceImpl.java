package com.mycompany.springbootelasticgymactivities.service;

import com.mycompany.springbootelasticgymactivities.exception.ActivityNotFoundException;
import com.mycompany.springbootelasticgymactivities.model.Activity;
import com.mycompany.springbootelasticgymactivities.repository.ActivityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }


    @Override
    public Activity save(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public void delete(Activity activity) {
        activityRepository.delete(activity);
    }

    @Override
    public Activity getActivityById(String id) {
        return activityRepository.findById(id).orElseThrow(() ->  new ActivityNotFoundException(id));
    }

    @Override
    public Page<Activity> listActivitiesByPage(Pageable pageable) {
        return activityRepository.findAll(pageable);
    }

    @Override
    public Iterable<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Page<Activity> search(String text, Pageable pageable) {
        return activityRepository.findByIdOrKindOrPlaceOrDescription(text, text, text, text, pageable);
    }
}
