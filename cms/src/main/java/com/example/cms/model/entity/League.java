package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Pair;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "leagues")
public class League {
    @Id
    private String leagueID;

    @NotEmpty
    private String leagueName;

    @NotEmpty
    private String leagueSport;

    @NotEmpty
    private String leagueGender;

    @NotEmpty
    private String leagueDivisionNumber;

    @OneToMany(mappedBy = "league")
    private List<Team> teams = new ArrayList<>();

    // standing and schedules queries from games

}
