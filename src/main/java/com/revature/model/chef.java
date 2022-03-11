package com.revature.model;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
@Entity
@Table(name="chef")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class chef {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String chefName;
    @Column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chefObject", fetch = FetchType.EAGER)
    private Collection<recipe> recipes = new ArrayList<>();
    @Column
    @Nullable
    private String specialty;
    @Column
    @Nullable
    private String tag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    @Nullable
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(@Nullable String specialty) {
        this.specialty = specialty;
    }

    @Nullable
    public String getTag() {
        return tag;
    }

    public void setTag(@Nullable String tag) {
        this.tag = tag;
    }
}
