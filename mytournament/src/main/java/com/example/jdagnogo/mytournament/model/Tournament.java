package com.example.jdagnogo.mytournament.model;

import com.example.jdagnogo.mytournament.model.Team;

import java.util.List;

public class Tournament {
    List<Team> teams;

    public Tournament(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
