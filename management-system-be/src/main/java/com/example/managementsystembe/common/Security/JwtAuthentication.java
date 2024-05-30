package com.example.managementsystembe.common.Security;

import com.example.managementsystembe.common.Security.token.AccessToken;
import com.example.managementsystembe.common.Security.token.AccessTokenProperties;
import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthentication extends AbstractAuthenticationToken {

    private final AccessToken accessToken;

    public JwtAuthentication(AccessToken accessToken) {
        super(accessToken.getAuthorities());
        this.accessToken = accessToken;
    }

    @Override
    public Object getCredentials() {
        return accessToken.getValueAsString();
    }

    @Override
    public AccessTokenProperties getPrincipal() {
        return accessToken.getProperties();
    }
}
