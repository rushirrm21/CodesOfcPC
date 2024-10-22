package com.cts.socialapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.socialapp.entity.UserPosts;

public interface UserPostsRepository extends JpaRepository<UserPosts, Integer> {

}
