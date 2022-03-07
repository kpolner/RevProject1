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
@Id
private int id;
@Column
private String recipeName;
@Column
private String foodType;
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn (name = "chefName")
public chef chef;
@Column
private String difficulty;
@Column
private double rating;
@Column
private int cookTime;
@Column
private String link;
}
