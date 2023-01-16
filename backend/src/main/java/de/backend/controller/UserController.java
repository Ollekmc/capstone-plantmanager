package de.backend.controller;

import de.backend.model.User;
import de.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping()
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> listUsers(@RequestParam Optional<String> search){
        if (search.isPresent()) {
            return userService.search(search.get());
        }
        return userService.list();
    }
    @GetMapping("{id}")
    public User getUser(@PathVariable String id) {
        return userService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);}

}
