package com.organimaster.org.config;

import com.organimaster.org.repository.TokenRepository;
import com.organimaster.org.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final TokenRepository tokenRepository;
    @Override
    protected void doFilterInternal(
            @org.springframework.lang.NonNull HttpServletRequest request,
            @org.springframework.lang.NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String userEmail;
        final boolean authPath = request.getServletPath().contains("/api/v1/auth");
        final boolean indexPath = request.getServletPath().contains("localhost");
        /* request is from /api/v1/auth */
        if (authPath) {
            filterChain.doFilter(request, response);
            return;
        }
        /* request is having Bearer */
        if (indexPath && authHeader == null) {
            filterChain.doFilter(request, response);
            return;
        } else if (!indexPath && authHeader == null) {
            Cookie[] cookies = request.getCookies();
            String cookieToken = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("accessToken".equals(cookie.getName())) {
                        cookieToken = cookie.getValue();
                        break;
                    }
                }
            }
            if (cookieToken == null) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "No authentication token found.");
                return;
            }
            /* request extract email from token */
            jwt = cookieToken;
            userEmail = jwtService.extractUsername(jwt);
        } else {
            /* request extract email from token */
            jwt = authHeader.substring(7);
            userEmail = jwtService.extractUsername(jwt);
        }
        /* if email not null and user not authenticated */
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            /* check if token is in token table not expired  */
            var isTokenValid = tokenRepository.findByToken(jwt)
                    .map(t -> !t.isExpired() && !t.isRevoked())
                    .orElse(false);
           if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
