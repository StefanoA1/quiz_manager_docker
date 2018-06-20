package fr.epita.quizManager.test;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz_manager.datamodel.User;
import fr.epita.quiz_manager.datamodel.UserType;
import fr.epita.quiz_manager.services.UserOperationsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestUser {

	@Inject
	SessionFactory factory;

	@Inject
	UserOperationsService userService;
	
	@Test
	public void testUserCreate() {
		User user1 = new User();
		user1.setName("Juan");
		user1.setPassword("test");
		user1.setUsername("hola");
		user1.setType(UserType.STUDENT);
		
		userService.createUser(user1);
		
		List<User> results = userService.search(user1);
		
		Assert.assertTrue(results.size() > 0);
	}
	
}
