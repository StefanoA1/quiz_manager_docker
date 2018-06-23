package fr.epita.quizManager.test;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
	UserOperationsService userService;
	
	@Before
	public void setup() {
		for(int i = 1; i <= 5 ; i++) {
			User user = new User();
			user.setName("user " + i);
			user.setPassword("test");
			user.setUsername("username " + i);
			user.setUserType(UserType.ADMIN);
			
			userService.createUser(user);
		}
		
	}
	
	@Test
	public void testUserCreateAndAutheticate() {
		User user1 = new User();
		user1.setName("Juan");
		user1.setPassword("test");
		user1.setUsername("hola");
		user1.setUserType(UserType.STUDENT);
		
		userService.createUser(user1);
		
		List<User> results = userService.search(user1);
		
		User criteria = new User();
		criteria.setPassword("test");
		criteria.setUsername("hola");
		Assert.assertTrue(results.size() > 0);
		Assert.assertTrue(userService.authenticate("hola", "test"));
	}
	
	@Test
	public void testUserSearch() {
		List<User> users = userService.search(new User());
		Assert.assertTrue(users.size() == 5);
	}
	
	@After
	public void tearDown() {
		for (User user : userService.search(new User())) {
			userService.deleteUser(user);
		}
	}
	
}
