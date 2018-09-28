package com.cg.service;

import java.util.List;

import com.cg.bean.Grocery;

public interface GroceryService {

	List<String> getCategoryList();
	boolean saveGrocery(Grocery groc);
	List<Grocery> getAllDetails();

}
