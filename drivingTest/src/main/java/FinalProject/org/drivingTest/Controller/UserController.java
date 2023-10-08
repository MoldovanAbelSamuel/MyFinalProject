package FinalProject.org.drivingTest.Controller;

import FinalProject.org.drivingTest.Model.Questionnaire;
import FinalProject.org.drivingTest.Model.User;
import FinalProject.org.drivingTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }
}
