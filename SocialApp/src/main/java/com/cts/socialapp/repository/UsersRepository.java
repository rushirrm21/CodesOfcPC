package com.cts.socialapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.socialapp.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

}
