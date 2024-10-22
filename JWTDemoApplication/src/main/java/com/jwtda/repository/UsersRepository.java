package com.jwtda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jwtda.entity.UserJWT;


@Repository
public interface UsersRepository extends JpaRepository<UserJWT, String> {

}

