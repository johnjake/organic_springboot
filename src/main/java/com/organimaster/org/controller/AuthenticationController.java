package com.organimaster.org.controller;

import com.organimaster.org.playload.request.AuthenticationRequest;
import com.organimaster.org.playload.request.RegisterRequest;
import com.organimaster.org.playload.response.AuthenticationResponse;
import com.organimaster.org.services.AuthenticationService;
import com.organimaster.org.utils.CookieUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletResponse response
    ) {
        var result = service.authenticate(request);
        var tokenValue = result.getAccessToken();
        var cookie = new Cookie("accessToken", tokenValue);
        System.out.println("******Cookie Token ****** " + tokenValue);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        response.addCookie(cookie);
        AuthenticationResponse authResponse = new AuthenticationResponse();
        authResponse.setAccessToken(tokenValue);
        return ResponseEntity.ok(authResponse);
    }
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
}

