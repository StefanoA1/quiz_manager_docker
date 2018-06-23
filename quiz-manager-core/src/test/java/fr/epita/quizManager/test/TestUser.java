package fr.epita.quizManager.test;

import java.util.List;

import javax.inject.Inject;

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

/**
 * <h3>Description</h3>
 * <p>This TestUser class is used to
 * test
 * operations
 *  for {@link UserOperationsService}
 * object types.</p>
 * 
 * <h3>Usage</h3>
 * <p>This class should be used as follows:<pre><code>
 *	See JUnit4
 *	for more information
 * </code></pre></p>
 *<p>
 * @author Stéfano Acosta - Álvaro Bilbao
 *</p>
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"/applicationContext.xml"})
public class TestUser {

	@Inject
	UserOperationsService userService;
	/**
	 * <h3>Description</h3>
	 * <p>Creates a Setup environment for testing.
	 * </p>
	 */
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
	/**
	 * <h3>Description</h3>
	 * <p>test create and Authenticate operations of User.
	 * </p>
	 */
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
	/**
	 * <h3>Description</h3>
	 * <p>test Search operations of User.
	 * </p>
	 */
	@Test
	public void testUserSearch() {
		List<User> users = userService.search(new User());
		Assert.assertTrue(users.size() == 5);
	}
	/**
	 * <h3>Description</h3>
	 * <p>Destroys the Setup environment for testing.
	 * </p>
	 */
	@After
	public void tearDown() {
		for (User user : userService.search(new User())) {
			userService.deleteUser(user);
		}
	}
	
}
