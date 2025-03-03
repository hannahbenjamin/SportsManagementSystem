package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "referee")

public class Referee extends User{

    // A referee can have many games but a game can only have one referee
    @OneToMany(mappedBy = "referee")
    @Nullable
    private List<Game> games = new ArrayList<>();

}


