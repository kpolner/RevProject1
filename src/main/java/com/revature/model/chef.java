package com.revature.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="chef")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class chef {
    @Id
    private int id;
    @Column
    private String chefName;
    @Column
    private String specialty;
    @Column
    private String tag;
}
