package io.springsecurity.springsecurityjwt.controller;

import io.springsecurity.springsecurityjwt.repository.UserRepository;
import io.springsecurity.springsecurityjwt.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class WebController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

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

}
