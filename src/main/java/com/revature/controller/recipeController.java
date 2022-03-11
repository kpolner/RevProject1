package com.revature.controller;
import com.revature.model.chef;
import com.revature.service.recipeService;
import com.revature.model.recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("top3/{food}")
    public List<recipe> getTop3(@PathVariable String food) {
        return recipeService.findTop3ByFoodType(food);
    }

    @GetMapping("fastest/{foodType}")
    public recipe getFastestCookTime(@PathVariable String foodType)
    {
        return recipeService.findFastestRecipe(foodType);
    }
    @GetMapping("id/{id}")
    public recipe getRecipeById(@PathVariable int id) {return recipeService.findRecipeById(id);}

    @PatchMapping("updateName/{id}/{recipeName}")
    public void updateName(@PathVariable int id, @PathVariable String recipeName) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setRecipeName(recipeName);
        recipeService.saveRecipe(recipe);
    }
    @PatchMapping("updateFoodType/{id}/{foodType}")
    public void updateFoodType(@PathVariable int id, @PathVariable String foodType) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setFoodType(foodType);
        recipeService.saveRecipe(recipe);
    }
    @PatchMapping("updateDifficulty/{id}/{difficulty}")
    public void updateDifficulty(@PathVariable int id, @PathVariable String difficulty) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setDifficulty(difficulty);
        recipeService.saveRecipe(recipe);
    }
    @PatchMapping("updateRating/{id}/{rating}")
    public void updateRating(@PathVariable int id, @PathVariable double rating) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setRating(rating);
        recipeService.saveRecipe(recipe);
    }
    @PatchMapping("updateCookTime/{id}/{cookTime}")
    public void updateCookTime(@PathVariable int id, @PathVariable int cookTime) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setCookTime(cookTime);
        recipeService.saveRecipe(recipe);
    }
    @PatchMapping("updateLink/{id}/{link}")
    public void updateLink(@PathVariable int id, @PathVariable String link) {
        recipe recipe = recipeService.findRecipeById(id);
        recipe.setLink(link);
        recipeService.saveRecipe(recipe);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Long> deleteRecipe(@PathVariable int id) {
        recipe recipe = recipeService.findRecipeById(id);
        if(recipe == null)
        {
            System.out.println("No recipe by this id");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            System.out.println(recipeService.findRecipeById(id).getRecipeName() + " deleted!");
            recipeService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}