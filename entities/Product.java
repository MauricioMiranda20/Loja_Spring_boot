package com.example.curse.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
//
@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Table(name="tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<Category>();
	
	public Set<Category> getCategories() {
		return categories;
	}
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<OrderItem>();
//	
	public Product(Long id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	
	public Product() {
		super();
	}	
	
	@JsonIgnore
	public Set<Order> getOrder(){
		Set<Order> item = new HashSet<Order>();
		for(OrderItem x:items) {
			item.add(x.getOrder());
		}
		return item;
	}

}
