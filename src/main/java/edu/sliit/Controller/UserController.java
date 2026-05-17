package edu.sliit.Controller;

import edu.sliit.dto.User;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    final UserService service;
    @PostMapping("/add-user")
    public void addUser(@RequestBody User user){
        service.addUser(user);
    }

    @GetMapping("/get-user/{userEmail}")
    public List<User> getUser(@PathVariable String userEmail){
        return service.searchUserByEmail(userEmail);
    }


    @GetMapping("/get-all-users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @PutMapping("/update-password/{userEmail}/{newPassword}")
    public void updatePassword(@PathVariable String userEmail, @PathVariable String newPassword) {

        service.updatePassword(userEmail, newPassword);
    }
}
