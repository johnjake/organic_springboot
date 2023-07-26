package com.organimaster.org.controller;

import com.organimaster.org.dto.UserDTO;
import com.organimaster.org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/user/register")
    public ResponseEntity<Integer> userRegistration(@RequestBody UserDTO user) {
        var userServ = userService.registerUser(
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getUserPass(),
                user.getEmailAdd()
        );
        return new ResponseEntity<>(userServ, HttpStatus.CREATED);
    }
}
