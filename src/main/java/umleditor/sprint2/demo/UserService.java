package umleditor.sprint2.demo;

/**
 * This is only for Demoing J-Mocking
 */

// UserService.java
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public String getUserName(String id) {
    User user = userRepository.findById(id);
    return user != null ? user.getName() : "User not found";
  }
}

