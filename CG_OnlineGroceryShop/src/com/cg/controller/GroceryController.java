package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.bean.Grocery;
import com.cg.service.GroceryService;


@Controller
public class GroceryController {
	
	//public static Logger logger = Logger.getRootLogger();
	

	@Autowired
	private GroceryService gService;
	
	@RequestMapping("/addGrocery")
	public String showGroceryForm(Model model){
		//PropertyConfigurator.configure("log4j.properties");
		System.out.println("show groc form");
		List<String> catList = gService.getCategoryList();
		
		//logger.info("Getting List");
		
		model.addAttribute("clist",catList);
		model.addAttribute("grocery",new Grocery());
		return "addgrocery";
	}
	
	@RequestMapping("/submitGrocery")
	public String showGroceryDetails(@ModelAttribute("grocery")@Valid Grocery grocery,BindingResult bindingResult,Model model){
		
		//System.out.println(grocery);
		boolean hasError = bindingResult.hasErrors();
		System.out.println("has error: " +hasError);
		if(hasError){
			List<String> catList = gService.getCategoryList();
			model.addAttribute("clist",catList);
			return "addgrocery";

		}
		else{
			System.out.println(grocery);
			boolean success = gService.saveGrocery(grocery);
			return "submitgrocery";
			
		}
		
	}
	@RequestMapping("/retrieveGrocery")
	public String showAllGrocery(Model model){
		//System.out.println("show groc form");
		PropertyConfigurator.configure("log4j.properties");

		List<Grocery> list = new ArrayList<Grocery>();
		list = gService.getAllDetails();
		//logger.info("Retrieving");
		model.addAttribute("all",list);
		//model.addAttribute("grocery",new Grocery());
		return "allgrocery";
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception e){
		
		//send email to call center/DBA here with exception
		/*System.out.println(e.getMessage());
		
		return "dataError";*/
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("err",e);
		mav.setViewName("dataError");
		return mav;
	}

}
