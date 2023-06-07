package lgda.manager.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " not found"));
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id) {
        User foundUser = getUserById(id);

        foundUser.setFirstname(user.getFirstname());
        foundUser.setLastname(user.getLastname());
        foundUser.setPhone(user.getPhone());
        foundUser.setEmail(user.getEmail());
        foundUser.setPassword(user.getPassword());
        foundUser.setBillingAddress(user.getBillingAddress());
        foundUser.setDeliveryAddress(user.getDeliveryAddress());
        foundUser.setIsActivated(user.getIsActivated());
        foundUser.setRole(user.getRole());

        return userRepository.save(foundUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
