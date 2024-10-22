package com.sa.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sa.user.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}