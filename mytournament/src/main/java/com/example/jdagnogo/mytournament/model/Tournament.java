package com.example.jdagnogo.mytournament.model;

import com.example.jdagnogo.mytournament.enums.TournamentRound;
import com.example.jdagnogo.mytournament.model.bundler.MatchBundler;
import com.example.jdagnogo.mytournament.model.bundler.TeamBundler;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.List;

import icepick.State;

@Parcel
public class Tournament {
    @State(TeamBundler.class)
    List<Team> teams;
    @State(MatchBundler.class)
    Match semiAMatch;
    @State(MatchBundler.class)
    Match semiBMatch;
    @State(MatchBundler.class)
    Match finalMatch;

    public Tournament() {

    }

    public Tournament(TournamentBuilder builder) {
        this.teams = builder.teams;
        this.semiBMatch = builder.semiBMatch;
        this.semiAMatch = builder.semiAMatch;
        this.finalMatch = builder.finalMatch;
    }

    public Tournament(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Match getSemiAMatch() {
        return semiAMatch;
    }

    public void setSemiAMatch(Match semiAMatch) {
        this.semiAMatch = semiAMatch;
    }

    public Match getSemiBMatch() {
        return semiBMatch;
    }

    public void setSemiBMatch(Match semiBMatch) {
        this.semiBMatch = semiBMatch;
    }

    public Match getFinalMatch() {
        return finalMatch;
    }

    public void setFinalMatch(Match finalMatch) {
        this.finalMatch = finalMatch;
    }

    public void addMatch(Match match) {
        switch (match.getCurentPosition()) {
            case SemiA:
                this.semiAMatch = match;
                match.getTeamA().setCurrentPosition(TournamentRound.SemiA);
                match.getTeamB().setCurrentPosition(TournamentRound.SemiA);
                break;
            case SemiB:
                this.semiBMatch = match;
                match.getTeamA().setCurrentPosition(TournamentRound.SemiB);
                match.getTeamB().setCurrentPosition(TournamentRound.SemiB);
                break;
            case Final:
                this.finalMatch = match;
                match.getTeamA().setCurrentPosition(TournamentRound.Final);
                match.getTeamB().setCurrentPosition(TournamentRound.Final);
                break;

        }
    }

    public HashMap<TournamentRound, Match> tournamentResult() {
        HashMap<TournamentRound, Match> result = new HashMap<>();
        result.put(TournamentRound.SemiA, semiAMatch);
        result.put(TournamentRound.SemiB, semiBMatch);
        result.put(TournamentRound.Final, finalMatch);

        return result;
    }

    public static class TournamentBuilder {
        List<Team> teams;
        private Match semiAMatch;
        private Match semiBMatch;
        private Match finalMatch;

        public TournamentBuilder(List<Team> teams) {
            this.teams = teams;
        }

        public Tournament build() {
            return new Tournament(this);
        }

        public TournamentBuilder addMatch(Match match) {
            switch (match.getCurentPosition()) {
                case SemiA:
                    this.semiAMatch = match;
                    match.getTeamA().setCurrentPosition(TournamentRound.SemiA);
                    match.getTeamB().setCurrentPosition(TournamentRound.SemiA);
                    break;

                case SemiB:
                    this.semiBMatch = match;
                    match.getTeamA().setCurrentPosition(TournamentRound.SemiB);
                    match.getTeamB().setCurrentPosition(TournamentRound.SemiB);
                    break;

                case Final:
                    this.finalMatch = match;
                    match.getTeamA().setCurrentPosition(TournamentRound.Final);
                    match.getTeamB().setCurrentPosition(TournamentRound.Final);
                    break;

            }
            return this;
        }

    }
}
