package com.example.managementsystembe.common.Security.token;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenExtractorConfig {

    @Bean
    @ConditionalOnProperty(name = "token.strategy", havingValue = "COOKIE", matchIfMissing = true)
    TokenExtractor cookieTokenExtractor(@Value("${token.cookie.name}") String tokenCookieName) {
        return new CookieTokenExtractor(tokenCookieName);
    }

    @Bean
    @ConditionalOnProperty(name = "token.strategy", havingValue = "HEADER")
    TokenExtractor authorizationHeaderTokenExtractor() {
        return new AuthorizationHeaderTokenExtractor();
    }

}
