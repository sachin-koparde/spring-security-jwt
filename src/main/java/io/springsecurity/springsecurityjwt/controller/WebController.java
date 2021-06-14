package io.springsecurity.springsecurityjwt.controller;

import io.springsecurity.springsecurityjwt.models.AuthenticationRequest;
import io.springsecurity.springsecurityjwt.models.AuthenticationResponse;
import io.springsecurity.springsecurityjwt.repository.UserRepository;
import io.springsecurity.springsecurityjwt.security.myUserDetailsService;
import io.springsecurity.springsecurityjwt.user.User;
import io.springsecurity.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@RestController
public class WebController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private myUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping("/")
    public String sayHello() {

        return "Hello";

    }

    @RequestMapping("/addUser")
    public String addUser() {

        User user = new User(1, "sach", "1234", "ROLE_ADMIN", true);

        userRepository.save(user);

        return "Added Successfully";

    }

    @RequestMapping("/user")
    public String user() {
        return "User";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = myUserDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }


}
