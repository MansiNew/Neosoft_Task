package com.neo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.model.User;

public interface UserRepo extends JpaRepository<User,Long> {

}
