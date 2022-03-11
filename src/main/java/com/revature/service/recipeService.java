package com.revature.service;

import com.revature.model.recipe;
import com.revature.repository.recipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.lang.annotation.*;
import java.util.List;


@Component
public class recipeService {
    recipeRepository recipeRepository;
    public recipeService(recipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public recipe findRecipeByName(String name) {
        return recipeRepository.findByName(name);
    }


    public recipe saveRecipe(recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public List<recipe> findAllRecipesByFoodType(String foodType) {
        return recipeRepository.findAllByFoodType(foodType);
    }
    public List<recipe> findAllRecipesByCookTime(int cookTime)
    {
        return recipeRepository.findAllByCookTimeBetween(cookTime-10, cookTime+10);
    }
    public List<recipe> findAllRecipesByChef(String chef) {
        return recipeRepository.findAllByChef(chef);
    }

    public List<recipe> findTop3ByFoodType(String food) {
        return recipeRepository.findTop3ByRating(food);
    }

    public void deleteById(int id) {
        recipeRepository.deleteById(id);
    }

    public recipe findRecipeById(int id) { return recipeRepository.findById(id); }
}
