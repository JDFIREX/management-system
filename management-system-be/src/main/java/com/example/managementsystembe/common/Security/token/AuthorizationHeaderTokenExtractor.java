package com.example.managementsystembe.common.Security.token;

import javax.servlet.http.HttpServletRequest;

import com.example.managementsystembe.common.Security.exception.InvalidTokenException;

class AuthorizationHeaderTokenExtractor implements TokenExtractor {

    @Override
    public String extract(HttpServletRequest request) {
        return subStringBearer(request.getHeader("Authorization"));
    }

    private String subStringBearer(String authorizationHeader) {
        try {
            return authorizationHeader.substring("Bearer ".length());
        } catch (Exception ex) {
            throw new InvalidTokenException("There is no AccessToken in a request header");
        }
    }

}
