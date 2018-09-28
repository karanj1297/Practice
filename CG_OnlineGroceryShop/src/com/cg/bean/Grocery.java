package com.cg.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name ="grocery_hib")
public class Grocery  {
	
	
	

	@Id
	@SequenceGenerator(name="g_seq" ,sequenceName="grocery_seq")
	@GeneratedValue(generator="g_seq")
/*	@GeneratedValue(strategy=GenerationType.AUTO)
*/	private int id;
	private String name;
	private float price;
	private String category;
	private int quantity;
	private String unit;
	private String description;
	public Grocery(int id, String name, float price, String category,
			int quantity, String unit, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
		this.unit = unit;
		this.description = description;
	}
	public Grocery() {
		super();
		
	}
	@Override
	public String toString() {
		return "Grocery [id=" + id + ", name=" + name + ", price=" + price
				+ ", category=" + category + ", quantity=" + quantity
				+ ", unit=" + unit + ", description=" + description + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Pattern(regexp = "[a-zA-Z]+",message="Please enter valid name")	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@DecimalMin(value = "1.0", inclusive = true)
	@DecimalMax(value = "1000.0", inclusive = true)
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Pattern(regexp = "^(?:(?!Select).)*$", message="Select a category")
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Min(1)	
	@Max(10)
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Pattern(regexp = "[a-zA-Z]+",message="Please enter valid unit")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@NotEmpty(message="Description is required")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
