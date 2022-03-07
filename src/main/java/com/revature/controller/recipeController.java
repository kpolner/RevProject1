package com.revature.controller;
import com.revature.model.chef;
import com.revature.service.recipeService;
import com.revature.model.recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Component
@RestController
@RequestMapping("recipe")
public class recipeController {
    recipeService recipeService;

    @Autowired
    public recipeController(recipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<recipe> getRecipes() {
        return recipeService.findAllRecipes();
    }

    @GetMapping("name/{name}")
    public recipe getRecipeByName(@PathVariable String name) {
        return recipeService.findRecipeByName(name);
    }

    @PostMapping()
    public recipe postRecipe(@RequestBody recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @GetMapping("foodType/{foodType}")
    public List<recipe> getRecipeByFoodType(@PathVariable String foodType) {
        return recipeService.findAllRecipesByFoodType(foodType);
    }

    @GetMapping("cookTime/{cookTime}")
    public List<recipe> getRecipeByCookTime(@PathVariable int cookTime) {
        return recipeService.findAllRecipesByCookTime(cookTime);
    }

    @GetMapping("chef/{chef}")
    public List<recipe> getRecipeByChef(@PathVariable String chef) {
        return recipeService.findAllRecipesByChef(chef);
    }

    @DeleteMapping("recipe/{recipe}")
    public recipe deleteRecipe(@PathVariable recipe recipe) {
        return recipeService.deleteRecipe(recipe);
    }

    @GetMapping("top3/{foodType}")
    public List<recipe> getTop3(@PathVariable String foodType) {
        return recipeService.findTop3ByFoodType(foodType);
    }
    @GetMapping("tag/{tag}")
    public List<recipe> getRecipeByChefTag(@PathVariable String tag) {
        return recipeService.findAllRecipesByChefTag(tag);
    }
}
    /*you're likely to also need
    a delete mapping
    @DeleteMapping
    a patch mapping
    @PatchMapping
     */
