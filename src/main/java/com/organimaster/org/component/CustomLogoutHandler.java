package com.organimaster.org.component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutHandler implements LogoutHandler {
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        System.out.println("User " + authentication.getName() + " is logging out.");
        // Perform additional cleanup or actions specific to your application
        // For example, you might want to invalidate user-related tokens or clear session data.
        // You can also redirect the user to a specific page after logout, if needed.
    }
}
