//*********************************************************************************************************************************
/* 5	When the project is using Spring 4.3 and Hibernate 5.2, how do you mock a DB in a JUnit test for a service method.
 		If not possible, give a reason why, otherwise list use cases for a different scenario?
 		
 		NOTE:	This solution assumes the supporting DAO, Model Object, Service Object, and Implementation are functional.

*///*********************************************************************************************************************************

//I would use a testing framework like Mockito to mock a database in memory, instead of pointing to an actual database

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	//Mocking an example service that notifies creation of a new user
	@Mock
	private UserNotificationService userNotificationService;
	
	//Mocking a User Data Acess Ojbect
	@Mock UserDAO userDAO;

	//Mock the User service implementation that contains service methods
	@InjectMocks
	private UserServiceImpl userService = new UserServiceImpl();

	@Test
	public void createNewUser() {
		
		//Let's declare our user information
		String userName = "kstoflet";
		String userTitle = "engineer";
		long userId = 00023;

		//Create our test user instances
		User userToSave = new User(userName, userTitle);
		User savedUser = new User(userName, userTitle);

		//Set the user information on the test instance
		savedUser.setUserId(userId);

		//Mockito flow
		when(userDAO.saveUser(Mockito.any(User.class))).thenReturn(savedUser);
		Mockito.doNothing().when(userNotificationService.notifyNewUser(userId);

		//Method to be tested
		User newUser = userService.createNewUser(userName, userTitle);

		//Check that the new user exists, and contains the right information
		assertNotNull(newUser);
		assertEquals(userId, newUser.getUserId());
		assertEquals(userName, newUser.getUserName());
		assertEquals(userTitle, newUser.getUserTitle());

		//Verify that methods called on our mock object are called correctly
		verify(userNotificationService).notifyNewUser(userId);
		verify(userDAO).save(userToSave);
	}

}