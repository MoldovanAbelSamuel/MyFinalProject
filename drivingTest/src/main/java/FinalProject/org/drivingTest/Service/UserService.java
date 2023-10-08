package FinalProject.org.drivingTest.Service;

import FinalProject.org.drivingTest.Model.User;
import FinalProject.org.drivingTest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User addUser(User user){
        return this.userRepository.save(user);
    }
}
