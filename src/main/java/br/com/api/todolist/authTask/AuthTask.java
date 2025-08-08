package br.com.api.todolist.authTask;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthTask extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var authHeaders = request.getHeader("Authorization");
        var clearAuthHeaders = authHeaders.substring("Basic".length()).trim();
        byte[] authDecode = Base64.getDecoder().decode(clearAuthHeaders);
        var authString = new String(authDecode);
        String[] credentials = authString.split(":");

        var username = credentials[0];
        var password = credentials[1];

        System.out.println(username);
        System.out.println(password);

        filterChain.doFilter(request, response);
    }

}
