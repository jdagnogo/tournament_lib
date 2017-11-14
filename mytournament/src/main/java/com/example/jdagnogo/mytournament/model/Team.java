package com.example.jdagnogo.mytournament.model;

import com.example.jdagnogo.mytournament.enums.TournamentRound;

import org.parceler.Parcel;

@Parcel
public class Team {
    private String name;
    private TournamentRound currentPosition;
    private boolean hasBeenEliminated;

    public Team(String name) {
        this.name = name;
        hasBeenEliminated = false;
    }

    public Team() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TournamentRound getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(TournamentRound currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isHasBeenEliminated() {
        return hasBeenEliminated;
    }

    public void setHasBeenEliminated(boolean hasBeenEliminated) {
        this.hasBeenEliminated = hasBeenEliminated;
    }
}
