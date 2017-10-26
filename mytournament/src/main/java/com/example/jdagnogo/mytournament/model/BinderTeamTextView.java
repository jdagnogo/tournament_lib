package com.example.jdagnogo.mytournament.model;

import android.widget.TextView;

public class BinderTeamTextView {
    private Team team;
    private TextView textViewName;
    private TextView textViewScore;

    public BinderTeamTextView(Team team, TextView textViewName) {
        this.team = team;
        this.textViewName = textViewName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public void setTextViewName(TextView textViewName) {
        this.textViewName = textViewName;
    }

}
