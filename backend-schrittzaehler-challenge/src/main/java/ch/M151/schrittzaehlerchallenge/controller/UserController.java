package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable long id) {
        return userService.getById(id);
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(long id) {
        userService.delete(id);
    }

    @DeleteMapping("/")
    public void deleteAll() {
        userService.deleteAll();
    }
}
