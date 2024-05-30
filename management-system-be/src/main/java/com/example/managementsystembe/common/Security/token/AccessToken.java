package com.example.managementsystembe.common.Security.token;

import java.util.Collection;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
public class AccessToken {
    private final String value;
    private final JsonNode decodedPayload;

    public String getValueAsString() {
        return value;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return StreamSupport.stream(decodedPayload.get("realm_access").get("roles").spliterator(), false)
            .map(JsonNode::asText)
            .map(SimpleGrantedAuthority::new)
            .collect(toList());
    }

    public AccessTokenProperties getProperties() {
        return new AccessTokenProperties(
            decodedPayload.get("preferred_username").asText(),
            decodedPayload.get("email").asText(),
            decodedPayload.get("given_name").asText(),
            decodedPayload.get("family_name").asText()
        );
    }
}
