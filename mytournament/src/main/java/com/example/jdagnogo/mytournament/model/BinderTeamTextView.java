package com.example.jdagnogo.mytournament.model;

import android.widget.TextView;

public class BinderTeamTextView {
    private Team team;
    private TextView textViewName;
    private TextView textViewScore;

    public BinderTeamTextView(Team team, TextView textViewName, TextView textViewScore) {
        this.team = team;
        this.textViewName = textViewName;
        this.textViewScore = textViewScore;
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

    public TextView getTextViewScore() {
        return textViewScore;
    }

    public void setTextViewScore(TextView textViewScore) {
        this.textViewScore = textViewScore;
    }
}
