package com.weatherapp.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.config.exception.ErrorResponse;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.*;

public class ClientAuthenticationFilter  extends OncePerRequestFilter {

    private final Map<String, String> clientCredentials = new HashMap<>();
    {
        clientCredentials.put("client1", "clientsecret0123456789");
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String clientId = request.getHeader("X-Client-Id");
        String clientSecret = request.getHeader("X-Client-Secret");

        if (clientId != null && clientCredentials.containsKey(clientId) && clientSecret.equals(clientCredentials.get(clientId))) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(clientId, clientSecret);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("Content-Type", "application/json");
            ErrorResponse error = new ErrorResponse("Invalid credentials", HttpServletResponse.SC_UNAUTHORIZED, new Date());
            ObjectMapper objectMapper = new ObjectMapper();
            response.getWriter().write(objectMapper.writeValueAsString(error));
            return;
        }

        filterChain.doFilter(request, response);
    }

}