package com.food.foodapplication.controller;

import com.food.foodapplication.model.Food;
import com.food.foodapplication.service.foodservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class foodcontroller {

    @Autowired
    private foodservice FoodService;

    public foodcontroller(foodservice FoodService) {
        this.FoodService = FoodService;
    }

    @PostMapping("/home")
    public String addFood(Food food, Model model) {

        if(food.getPrice() > 1000){
            model.addAttribute("errorMessage", "Price is too high");
        } else if(FoodService.addFood(food) <1 ){
            model.addAttribute("errorMessage", "Could not add food");
        } else{
            model.addAttribute("successMessage", "Food added"); 
        }
        
        Food[] foods = FoodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }
    
    @GetMapping("/home")
    public String getHome(Model model,Food food){
        //model.addAttribute("message", "Hello World");
        Food[] foods = FoodService.getFoods();
        model.addAttribute("foods", foods);
        return "home";
    }
}
