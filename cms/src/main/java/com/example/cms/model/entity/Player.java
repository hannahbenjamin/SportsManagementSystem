package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "players")
public class Player extends User{
    private ArrayList<Team> teamID ;
}

