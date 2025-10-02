package com.example.curse.repository;

//import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.curse.entities.OrderItem;
import com.example.curse.entities.pk.OrderItemPK;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
//	Optional<User> findbyName(String name);
}
