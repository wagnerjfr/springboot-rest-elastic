package com.mycompany.springbootelasticgymactivities.repository;

import com.mycompany.springbootelasticgymactivities.model.Activity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ActivityRepository extends ElasticsearchRepository<Activity, String> {

}
