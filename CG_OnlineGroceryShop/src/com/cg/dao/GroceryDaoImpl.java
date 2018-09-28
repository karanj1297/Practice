package com.cg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;





import com.cg.bean.Category;
import com.cg.bean.Grocery;

@Transactional
@Repository
public class GroceryDaoImpl implements GroceryDao {

	@PersistenceContext
	private EntityManager eManager;

	@Override
	public List<String> getCategoryList() {

		// JPA code here
		List<String> categoryList = new ArrayList<String>();
		
		String result = "SELECT cat.category from Category cat";
		//String result = "SELECT category from Category category";

		
		TypedQuery<String> query = eManager.createQuery(result,String.class);
		
		categoryList = query.getResultList();
		return categoryList;

		
	}

	@Override
	public boolean saveGrocery(Grocery groc) {
		// TODO Auto-generated method stub
		boolean check = false;
		try{
			
			
			eManager.persist(groc);
			
			System.out.println("added");
			check = true;
		}catch(Exception e){
			
			System.out.println("Done");
		}
		
		
		return check;
	}

	@Override
	public List<Grocery> getAllDetails() {
		// TODO Auto-generated method stub
		List<Grocery> grocList = new ArrayList<Grocery>();
		
		String result = "SELECT grocery from Grocery grocery";
		//String result = "SELECT category from Category category";

		
		TypedQuery<Grocery> query = eManager.createQuery(result,Grocery.class);
		
		grocList = query.getResultList();
		return grocList;
		
	}

}
