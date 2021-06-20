package ch.M151.schrittzaehlerchallenge.controller;

import ch.M151.schrittzaehlerchallenge.dto.LoginRequest;
import ch.M151.schrittzaehlerchallenge.dto.UserDto;
import ch.M151.schrittzaehlerchallenge.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{username}")
    public ResponseEntity getCurrent(@PathVariable Optional<String> username) {
        try {
            return ResponseEntity.ok(this.userService.getUser(username));
        } catch (Exception e) {
            return ResponseEntity.status(405).body(e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity getCurrent(@RequestBody final LoginRequest loginRequest) {
        try {
            return ResponseEntity.ok(this.userService.login(loginRequest));
        } catch (Exception e) {
            return ResponseEntity.status(403).body("username and|or password are not correct");
        }
    }
}
