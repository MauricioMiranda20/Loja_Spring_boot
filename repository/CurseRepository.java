package com.example.curse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curse.entities.User;


@Repository
public interface CurseRepository extends JpaRepository<User, Long> {

//	User saveUser(String name, String email, String phone, String password);
	Optional<User> findByName(String name);
}


