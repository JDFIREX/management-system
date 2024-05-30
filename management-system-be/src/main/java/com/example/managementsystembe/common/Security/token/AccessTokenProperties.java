package com.example.managementsystembe.common.Security.token;

import lombok.Value;

@Value
public class AccessTokenProperties {

    String preferredUsername;
    String email;
    String givenName;
    String familyName;

}
