package com.example.curse.service;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curse.entities.Order;
import com.example.curse.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// esse aqui e feito para o @GetMapping
	public List<Order> buscarContato() {
		return orderRepository.findAll();
	}

	// ess aqui vai procurar com o id no banco de dado @GetMapping("{id}")
	public Order buscarContatoId(Long Id) {
		Optional<Order> order = orderRepository.findById(Id);
		return order.get();
	}

	// esse ele vai adicionar o valor no banco de dado @PostMapping
	public Order salvarUsuario(Order Order) {
		return orderRepository.save(Order);
	}
}
