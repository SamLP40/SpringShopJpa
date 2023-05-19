package fr.fms.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String brand;
	private double price;
	
	@ManyToOne
	private Category category; // Plusieurs articles sont liés à une catégorie en BDD
	 
	public Article(String description, String brand, double price, Category category) {
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	public Article(String description, String brand, double price) {
		super();
		this.brand = brand;
		this.description = description;
		this.price = price;
	}
	
	public Article(Long id, String description, String brand, double price) {
		this.id = id;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}
	public Article() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + ", brand=" + brand + ", price=" + price
				+ "]";
	}

}