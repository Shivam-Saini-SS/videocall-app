package com.project.VideoCall.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PostMapping("/logout")
    public void logoutUser(@RequestBody String email) {
        userService.logoutUser(email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        e.printStackTrace();
        return ResponseEntity
                .status(INTERNAL_SERVER_ERROR)
                .body(e.getMessage());
    }
}
