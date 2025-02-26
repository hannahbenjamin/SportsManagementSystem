package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "sports")

public class Sport {

    @Id
    private long sportID;

    @NotEmpty
    private String sportName;

    @NotEmpty
    private ArrayList<Division> divisions;

    @NotEmpty
    private int teamSize;

}
