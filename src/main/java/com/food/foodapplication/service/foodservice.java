package com.food.foodapplication.service;

import com.food.foodapplication.mapper.FoodMapper;
import com.food.foodapplication.model.Food;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class foodservice {

    private FoodMapper foodMapper;
    
    public foodservice(FoodMapper foodMapper) {
        this.foodMapper = foodMapper;
    }

    public int addFood(Food food){
        return foodMapper.insertFood(food); 
    }

    public Food[] getFoods(){
        Food[] foods = foodMapper.selectFoods();

        return foods;
    }
}
