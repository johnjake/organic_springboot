package com.organimaster.org.utils;

import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void setTokenCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        // Set other cookie attributes like domain, path, secure, etc., if required
        response.addCookie(cookie);
    }

    public static void setRefreshTokenCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public static void setArrayCookie(HttpServletResponse response, String name, String[] values) {
        // Convert the array to a JSON string
        String jsonStr = new Gson().toJson(values);
        // Set the JSON string as the value of the cookie
        Cookie cookie = new Cookie(name, jsonStr);
        // Set other cookie attributes like domain, path, secure, etc., if required
        response.addCookie(cookie);
    }
}
