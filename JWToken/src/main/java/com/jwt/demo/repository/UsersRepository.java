package com.jwt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwt.demo.entity.UserJWT;

@Repository
public interface UsersRepository extends JpaRepository<UserJWT, String> {

}