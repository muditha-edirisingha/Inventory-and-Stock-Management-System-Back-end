package edu.sliit.Controller;

import edu.sliit.dto.User;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public User getUser(@PathVariable String userEmail){
        return service.searchUserByEmail(userEmail);
    }

}
