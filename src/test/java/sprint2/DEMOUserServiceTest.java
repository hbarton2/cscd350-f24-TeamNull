package sprint2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import umleditor.demo.User;
import umleditor.demo.UserRepository;
import umleditor.demo.UserService;

@ExtendWith(MockitoExtension.class)
public class DEMOUserServiceTest {

  @Mock
  private UserRepository userRepository;  // Mocking the UserRepository

  @InjectMocks
  private UserService userService;  // Injecting mock into UserService

  @Test
  public void testGetUserName_UserExists() {
    // Arrange
    User mockUser = new User("1", "John Doe");
    when(userRepository.findById("1")).thenReturn(mockUser);  // Defining behavior for the mock

    // Act
    String userName = userService.getUserName("1");

    // Assert
    assertEquals("John Doe", userName);
    verify(userRepository, times(1)).findById("1");  // Verify interaction with the mock
  }

  @Test
  public void testGetUserName_UserDoesNotExist() {
    // Arrange
    when(userRepository.findById("2")).thenReturn(null);  // Mocking a non-existent user

    // Act
    String userName = userService.getUserName("2");

    // Assert
    assertEquals("User not found", userName);
    verify(userRepository, times(1)).findById("2");
  }
}
