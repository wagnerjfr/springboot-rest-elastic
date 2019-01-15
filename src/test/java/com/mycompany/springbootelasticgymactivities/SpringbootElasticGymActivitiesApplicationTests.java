package com.mycompany.springbootelasticgymactivities;

import com.mycompany.springbootelasticgymactivities.model.Activity;
import com.mycompany.springbootelasticgymactivities.service.ActivityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticGymActivitiesApplicationTests {

/*	@Autowired
	private ActivityService activityService;

	@Autowired
	private ElasticsearchTemplate esTemplate;

	@Before
	public void before() {
		esTemplate.deleteIndex(Activity.class);
		esTemplate.createIndex(Activity.class);
		esTemplate.putMapping(Activity.class);
		esTemplate.refresh(Activity.class);
	}


	@Test
	public void testSave() {
		Activity activity = new Activity(new Date(), "Strenght", "Indoor", "workout");
		Activity testActivity = activityService.save(activity);

		assertNotNull(testActivity.getId());
	}*/
}