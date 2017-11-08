package com.example.jdagnogo.tournamentSample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jdagnogo.mytournament.enums.TournamentRound;
import com.example.jdagnogo.mytournament.model.Match;
import com.example.jdagnogo.mytournament.model.Team;
import com.example.jdagnogo.mytournament.model.Tournament;
import com.example.jdagnogo.mytournament.TournamentView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TournamentView tournamentView;
    Team arsenal, real, milan, psg;
    List<Team> allTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.set_teams).setOnClickListener(this);
        findViewById(R.id.reset).setOnClickListener(this);
        findViewById(R.id.simulate).setOnClickListener(this);
        // Create all teams
        arsenal = new Team("Arsenal");
        real = new Team("Real Madrid");
        milan = new Team("Milan AC");
        psg = new Team("PSG");

        //Add team into the tournament
        allTeam = new ArrayList<>();
        allTeam.add(arsenal);
        allTeam.add(real);
        allTeam.add(milan);
        allTeam.add(psg);


        tournamentView = (TournamentView) findViewById(R.id.tournament_view);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.set_teams:
                tournamentView.setTournament(new Tournament(allTeam));
                tournamentView.startTournament();
                break;
            case R.id.simulate:
                Match semiA = new Match.MatchResultBuilder(arsenal, real).currentPosition(TournamentRound.SemiA).scoreA(5).scoreB(0).build();
                Match semiB = new Match.MatchResultBuilder(milan, psg).currentPosition(TournamentRound.SemiB).scoreA(4).scoreB(3).build();
                Match finalMatch = new Match.MatchResultBuilder(arsenal, milan).currentPosition(TournamentRound.Final).scoreA(4).scoreB(0).build();


                // Create a tournament
                Tournament championLeague = new Tournament.TournamentBuilder(allTeam).addMatch(semiA).addMatch(semiB).build();
                championLeague.addMatch(finalMatch);

                tournamentView.setTournament(championLeague);
                tournamentView.startTournament();
                tournamentView.simulate();

                break;
            case R.id.reset:
                tournamentView.resetView();
                break;

        }
    }
}
