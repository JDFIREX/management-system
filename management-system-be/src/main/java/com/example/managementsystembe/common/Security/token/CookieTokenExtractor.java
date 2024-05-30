package com.example.managementsystembe.common.Security.token;

import java.util.Arrays;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.example.managementsystembe.common.Security.exception.InvalidTokenException;

class CookieTokenExtractor implements TokenExtractor {

    private final String tokenCookieName;

    public CookieTokenExtractor(String tokenCookieName) {
        this.tokenCookieName = tokenCookieName;
    }

    @Override
    public String extract(HttpServletRequest request) {
        Cookie tokenCookie = getTokenCookie(request);
        if (tokenCookie.getValue() == null) {
            throw new InvalidTokenException("Token has not been provided");
        }
        return tokenCookie.getValue();
    }

    private Cookie getTokenCookie(HttpServletRequest request) {
        return Arrays.stream(getCookies(request))
                .filter(cookie -> cookie.getName().equals(tokenCookieName))
                .findFirst()
                .orElseThrow(() -> new InvalidTokenException("Token cookie has not been provided"));
    }

    private Cookie[] getCookies(HttpServletRequest request) {
        if (request.getCookies() == null) {
            throw new InvalidTokenException("Token cookie has not been provided");
        }
        return request.getCookies();
    }

}
