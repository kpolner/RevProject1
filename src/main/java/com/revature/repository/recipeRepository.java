package com.revature.repository;
import com.revature.model.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface recipeRepository extends JpaRepository<recipe, Integer> {
    recipe save(recipe recipe);

    @Query("FROM recipe")
    List<recipe> findAll();

    @Query("FROM recipe WHERE recipeName = ?1")
    recipe findByName(String name);

    @Query("FROM recipe WHERE foodType = ?1")
    List<recipe> findAllByFoodType(String foodType);

    @Query("FROM recipe")
    List<recipe> findAllByCookTimeBetween(int cookTimeLess, int cookTimePlus);

    @Query("FROM recipe WHERE chefObject = ?1")
    List<recipe> findAllByChef(String chef);

    @Query
    void deleteById(int id);

    @Query(value = "SELECT top 3 * FROM recipe WHERE food_type = ?1 ORDER BY rating DESC", nativeQuery = true)
    List<recipe> findTop3ByRating(String food);

    @Query("FROM recipe WHERE id = ?1")
    recipe findById(int Id);
}
