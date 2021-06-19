package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

}
