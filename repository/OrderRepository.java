package com.example.curse.repository;

//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curse.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//	Optional<User> findbyName(String name);
}
