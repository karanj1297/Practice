package com.cg.dao;

import java.util.List;

import com.cg.bean.Grocery;

public interface GroceryDao {

	List<String> getCategoryList();

	boolean saveGrocery(Grocery groc);

	List<Grocery> getAllDetails();

}
