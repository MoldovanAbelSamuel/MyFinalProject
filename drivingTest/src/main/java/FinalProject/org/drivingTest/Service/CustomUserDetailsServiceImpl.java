package FinalProject.org.drivingTest.Service;

import FinalProject.org.drivingTest.Model.User;
import FinalProject.org.drivingTest.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Load user data from your database or any other source
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Return a UserDetails object or a custom User class that implements UserDetails
        // For example:
        // return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());

        // Alternatively, you can map your User entity to a UserDetails object using a custom UserDetailsService or UserDetailsBuilder.
        // For example:
        // return UserDetailsBuilder.build(user);

        return user; // If your User entity implements UserDetails
    }
}
