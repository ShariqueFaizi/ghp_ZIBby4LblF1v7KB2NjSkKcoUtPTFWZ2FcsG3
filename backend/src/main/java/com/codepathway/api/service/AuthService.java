package com.codepathway.api.service;

import com.codepathway.api.dto.AuthRequest;
import com.codepathway.api.dto.RegisterRequest;
import com.codepathway.api.entity.Role;
import com.codepathway.api.entity.User;
import com.codepathway.api.repository.RoleRepository;
import com.codepathway.api.repository.UserRepository;
import com.codepathway.api.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already taken");
        }
        User user = new User(request.getFullName(), request.getEmail(), passwordEncoder.encode(request.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new RuntimeException("Role missing"));
        Set<Role> roles = new HashSet<>(); roles.add(role); user.setRoles(roles);
        userRepository.save(user);
        return jwtUtil.generateToken(user.getEmail());
    }

    public String login(AuthRequest request) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        return jwtUtil.generateToken(request.getEmail());
    }
}
