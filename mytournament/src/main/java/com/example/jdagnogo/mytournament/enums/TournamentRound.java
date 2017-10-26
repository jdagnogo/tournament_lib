package com.example.jdagnogo.mytournament.enums;

public enum TournamentRound {
    Semi(2),
    Final(0),
    Winner(1);

    private int round;

    TournamentRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}
