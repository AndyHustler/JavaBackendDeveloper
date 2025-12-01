package backend.developer.progectjbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.developer.progectjbd.model.User;
import backend.developer.progectjbd.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/user-api")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return service.listUsers();
    }

    @GetMapping("/user/{id}")
    public User findUser(@PathVariable(name = "id") Long id) {
        return service.findUser(id).orElseThrow();
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user) {
        return service.createUser(user);
    }
}
