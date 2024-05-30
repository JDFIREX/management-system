package com.example.managementsystembe.common.Security.token;

import javax.servlet.http.HttpServletRequest;

public interface TokenExtractor {

    /**
     * Extracts token value from request.
     *
     * @param request incoming request
     * @return JWT token value (in case of "Bearer [token]" returns only [token] part)
     */
    String extract(HttpServletRequest request);

}
