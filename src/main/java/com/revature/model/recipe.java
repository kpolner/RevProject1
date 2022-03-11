package com.revature.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
@Table(name="recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class recipe {
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int id;
@Column
private String recipeName;
@Column
private String foodType;
@ManyToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
@JoinColumn(name = "recipeChef")
public chef chefObject;
@Column
private String difficulty;
@Column
private double rating;
@Column
private int cookTime;
@Column
private String link;

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
