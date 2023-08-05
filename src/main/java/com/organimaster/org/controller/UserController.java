package com.organimaster.org.controller;

import com.organimaster.org.dto.UserDTO;
import com.organimaster.org.playload.request.AccessTokenRequest;
import com.organimaster.org.playload.response.AccessTokenResponse;
import com.organimaster.org.services.RegistrationService;
import com.organimaster.org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final RegistrationService regService;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, RegistrationService regService) {
        this.userService = userService;
        this.regService = regService;
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

    @GetMapping("/api/user/reg_token/{email}")
    public ResponseEntity<AccessTokenResponse> token(
            @PathVariable("email") String request) {
            var param = new AccessTokenRequest(request);
        return ResponseEntity.ok(regService.getTokenRegister(param));
    }
}
