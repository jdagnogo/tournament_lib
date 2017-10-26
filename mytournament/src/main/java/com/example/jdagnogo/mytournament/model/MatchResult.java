package com.example.jdagnogo.mytournament.model;

import com.example.jdagnogo.mytournament.enums.TournamentRound;

public class MatchResult {
    private Team teamA;
    private Team teamB;
    private TournamentRound curentPosition;
    private int scoreA;
    private int scoreB;

   private MatchResult(MatchResultBuilder builder){
       this.teamA = builder.teamA;
       this.teamB = builder.teamB;
       this.curentPosition = builder.curentPosition;
       this.scoreA = builder.scoreA;
       this.scoreB = builder.scoreB;

   }
   public Team getTheWinner(){
       return null;
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
    }
}
