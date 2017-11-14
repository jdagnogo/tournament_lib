package com.example.jdagnogo.mytournament.model;

import com.example.jdagnogo.mytournament.enums.TournamentRound;
import com.example.jdagnogo.mytournament.model.bundler.TeamBundler;

import org.parceler.Parcel;

import icepick.State;

@Parcel
public class Match {
    @State(TeamBundler.class)
    Team teamA;
    @State(TeamBundler.class)
    Team teamB;
    private TournamentRound curentPosition;
    private int scoreA;
    private int scoreB;

    public Match() {

    }

    private Match(MatchResultBuilder builder) {
        this.teamA = builder.teamA;
        this.teamB = builder.teamB;
        this.curentPosition = builder.curentPosition;
        this.scoreA = builder.scoreA;
        this.scoreB = builder.scoreB;

    }

    public Team getWinner() {
        if (scoreA > scoreB) {
            teamB.setHasBeenEliminated(true);
            return teamA;
        } else if (scoreA == scoreB) {
            return null;
        } else {
            teamA.setHasBeenEliminated(true);
            return teamB;
        }
    }

    public TournamentRound getCurentPosition() {
        return curentPosition;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public void setCurentPosition(TournamentRound curentPosition) {
        this.curentPosition = curentPosition;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public static class MatchResultBuilder {
        private Team teamA;
        private Team teamB;
        private TournamentRound curentPosition;
        private int scoreA;
        private int scoreB;

        public MatchResultBuilder(Team teamA, Team teamB) {
            this.teamA = teamA;
            this.teamB = teamB;
            scoreA = 0;
            scoreB = 0;
        }

        public MatchResultBuilder currentPosition(TournamentRound curentPosition) {
            this.curentPosition = curentPosition;
            return this;
        }

        public MatchResultBuilder scoreA(int scoreA) {
            this.scoreA = scoreA;
            return this;
        }

        public MatchResultBuilder scoreB(int scoreB) {
            this.scoreB = scoreB;
            return this;
        }

        public Match build() {
            return new Match(this);
        }


    }
}
