package com.mycompany.springbootelasticgymactivities.repository;

import com.mycompany.springbootelasticgymactivities.model.Activity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ActivityRepository extends ElasticsearchRepository<Activity, String> {

    Page<Activity> findByIdOrKindOrPlaceOrDescription(String id, String kind, String place, String description, Pageable pageable);
}
