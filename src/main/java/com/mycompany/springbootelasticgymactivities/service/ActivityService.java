package com.mycompany.springbootelasticgymactivities.service;

import com.mycompany.springbootelasticgymactivities.model.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ActivityService {

    Activity save(Activity activity);

    void delete(Activity activity);

    Activity getActivityById(String id);

    Page<Activity> listActivitiesByPage(Pageable pageable);

    Iterable<Activity> findAll();

    Page<Activity> search(String text, Pageable pageable);

}
