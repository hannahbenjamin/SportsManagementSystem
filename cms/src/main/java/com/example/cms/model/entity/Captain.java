package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "captains")

public class Captain extends User{

    // each team can only have one captain and one captain can only be on one team
//    @OneToOne
//    @JoinColumn(name = "teamID") // FK
//    private Team team;

    @OneToOne(mappedBy = "captain") // This is the inverse side of the relationship
    private Team team;

}
