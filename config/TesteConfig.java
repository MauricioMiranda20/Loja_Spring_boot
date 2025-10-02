package com.example.curse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.curse.entities.Category;
import com.example.curse.entities.Order;
import com.example.curse.entities.OrderItem;
import com.example.curse.entities.Payment;
import com.example.curse.entities.Product;
import com.example.curse.entities.User;
import com.example.curse.entities.enums.OrderStatus;
import com.example.curse.repository.CategoryRepository;
import com.example.curse.repository.CurseRepository;
import com.example.curse.repository.OrderItemRepository;
import com.example.curse.repository.OrderRepository;
import com.example.curse.repository.ProductRepository;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

	@Autowired
	private CurseRepository curseRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws RuntimeException {
		
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		

		Order o1 = new Order(null,OrderStatus.PAID,Instant.parse("2019-06-20T19:53:07Z"),u1);
		Order o2 = new Order(null,OrderStatus.SHIPPED,Instant.parse("2019-07-21T03:42:10Z"),u2);
		Order o3 = new Order(null,OrderStatus.CANCELED,Instant.parse("2019-07-22T15:21:22Z"),u1);
		
		curseRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

		
		Category cat1 = new Category(null,"Electronics");
		Category cat2 = new Category(null,"Books");
		Category cat3 = new Category(null,"Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1,p1,2,p4.getPrice());
		OrderItem oi2 = new OrderItem(o2,p2,1,p3.getPrice());
		OrderItem oi3 = new OrderItem(o3,p3,2,p2.getPrice());
		OrderItem oi4 = new OrderItem(o1,p4,2,p1.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}

}
