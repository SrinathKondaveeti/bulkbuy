package com.bulkbuy.security.filter;

import com.bulkbuy.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService; // Our CustomUserDetailsService

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull FilterChain filterChain) throws ServletException, IOException {
        System.out.println("@#$$$$$$$$$$$$$$$$$$ JwtAuthenticationFilter entered $$$$$$$$$$$$$$$$$$$$$$$#@");
        System.out.println("@#$$$$$$$$$$$$$$$$$$ JwtAuthenticationFilter URL $$$$$$$$$$$$$$$$$$$$$$$#@" + request.getRequestURI());

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            System.out.println("@#$$$$$$$$$$$$$$$$$$ Authorization header not available $$$$$$$$$$$$$$$$$$$$$$$#@");
            filterChain.doFilter(request, response);
            return;
        }

        System.out.println("@#$$$$$$$$$$$$$$$$$$ Authorization header available $$$$$$$$$$$$$$$$$$$$$$$#@");

        jwt = authHeader.substring(7);
        username = jwtService.extractUsername(jwt);
        System.out.println("@#$$$$$$$$$$$$$$$$$$ User Name $$$$$$$$$$$$$$$$$$$$$$$#@+"+username);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            System.out.println("@#$$$$$$$$$$$$$$$$$$ User getPassword $$$$$$$$$$$$$$$$$$$$$$$#@+"+userDetails.getPassword());


            if (jwtService.validateToken(jwt, userDetails)) {
                System.out.println("@#$$$$$$$$$$$$$$$$$$ Token Valid $$$$$$$$$$$$$$$$$$$$$$$#@+");

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }else{

                System.out.println("@#$$$$$$$$$$$$$$$$$$ Token In Valid $$$$$$$$$$$$$$$$$$$$$$$#@+");

            }
        }
        filterChain.doFilter(request, response);
    }
}