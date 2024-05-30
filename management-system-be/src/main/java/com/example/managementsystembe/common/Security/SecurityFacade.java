package com.example.managementsystembe.common.Security;

import com.example.managementsystembe.common.Security.token.AccessTokenProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@RequiredArgsConstructor
public class SecurityFacade {

    public AccessTokenProperties getCurrentUserPrincipal() {
        var principal = SecurityContextHolder.getContext().getAuthentication();
        return (AccessTokenProperties) principal.getPrincipal();
    }

    public boolean isAdmin() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return principal.stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("admin"));
    }
}
