package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="grocery_category")
public class Category {
	
	
	@Id
	private String category;

	@Override
	public String toString() {
		return "Category [category=" + category + "]";
	}

	public Category() {
		
	}

	public Category(String category) {
		super();
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
