package org.wecancodeit.albumapp.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeControllerTest {
	
	@Autowired
	private HomeController testHomeController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(testHomeController).isNotNull();
	}

}
