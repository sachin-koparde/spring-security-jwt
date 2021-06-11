package io.springsecurity.springsecurityjwt.repository;

import io.springsecurity.springsecurityjwt.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface UserRepository extends JpaRepository<User, Integer> {
}
