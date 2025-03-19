package com.microservice.user.service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.user.service.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
