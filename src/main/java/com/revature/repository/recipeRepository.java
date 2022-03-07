package com.revature.repository;
import com.revature.model.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface recipeRepository extends JpaRepository<recipe, Integer> {
    @Query("FROM recipe")
    recipe save(recipe recipe);

    @Query("FROM recipe")
    List<recipe> findAll();

    @Query("FROM recipe")
    recipe findByName(String name);

    @Query("FROM recipe")
    List<recipe> findAllByFoodType(String foodType);

    @Query("FROM recipe")
    List<recipe> findAllByCookTimeBetween(int cookTimeLess, int cookTimePlus);

    @Query("FROM recipe")
    List<recipe> findAllByChef(String chef);

    @Query("FROM recipe")
    recipe deleteBy(recipe recipe);

    @Query(value = "SELECT * FROM recipe WHERE foodType = ?1 ORDER BY rating LIMIT 3", nativeQuery = true)
    List<recipe> findTop3ByRating(String foodType);

    @Query(value = "SELECT * FROM recipe WHERE TAG = ?1 INNER JOIN chef ON recipe.chefName = chef.chefName", nativeQuery = true)
    List<recipe> findAllByChefTag(String tag);
}
