package com.example.jdagnogo.mytournament.model;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

public class BinderTeamTextView {
    private Team team;
    private TextView textViewName;
    private TextView textViewScore;
    private CardView cardView;



    public BinderTeamTextView(Team team, TextView textViewName, TextView textViewScore, CardView cardView) {
        this.team = team;
        this.textViewName = textViewName;
        this.textViewScore = textViewScore;
        this.cardView = cardView;

    }

    public CardView getCardView() {

        return cardView;
    }

    public void setCardView(CardView cardView) {
        this.cardView = cardView;
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
