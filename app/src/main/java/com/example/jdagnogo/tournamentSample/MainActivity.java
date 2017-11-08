package com.example.jdagnogo.tournamentSample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jdagnogo.mytournament.enums.TournamentRound;
import com.example.jdagnogo.mytournament.model.Match;
import com.example.jdagnogo.mytournament.model.Team;
import com.example.jdagnogo.mytournament.model.Tournament;
import com.example.jdagnogo.mytournament.TournamentView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Create all teams
        Team arsenal = new Team("Arsenal");
        Team real = new Team("Real Madrid");
        Team milan = new Team("Milan AC");
        Team psg = new Team("PSG");

        //Add team into the tournament
        List<Team> allTeam = new ArrayList<>();
        allTeam.add(arsenal);
        allTeam.add(real);
        allTeam.add(milan);
        allTeam.add(psg);

        Match semiA = new Match.MatchResultBuilder(arsenal,real).currentPosition(TournamentRound.SemiA).scoreA(5).scoreB(0).build();
        Match semiB = new Match.MatchResultBuilder(milan,psg).currentPosition(TournamentRound.SemiB).scoreA(4).scoreB(3).build();
        Match finalMatch = new Match.MatchResultBuilder(arsenal,milan).currentPosition(TournamentRound.Final).scoreA(4).scoreB(0).build();


        // Create a tournament
        Tournament championLeague = new Tournament.TournamentBuilder(allTeam).addMatch(semiA).addMatch(semiB).build();
        championLeague.addMatch(finalMatch);

        TournamentView tournamentView = (TournamentView) findViewById(R.id.tournament_view);
        tournamentView.setTournament(championLeague);
        tournamentView.startTournament();


        tournamentView.simulate();
    }
}
