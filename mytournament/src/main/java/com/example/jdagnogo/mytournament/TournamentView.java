package com.example.jdagnogo.mytournament;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdagnogo.mytournament.model.BinderTeamTextView;
import com.example.jdagnogo.mytournament.model.Tournament;

import java.util.ArrayList;
import java.util.List;


public class TournamentView extends LinearLayout {
    /*
    All Views
     */
    View rootView;
    LinearLayout mainLayout;
    TextView semiACard1Textview, semiACard2Textview, semiBCard1Textview, semiBCard2Textview;


    /*
    beans
     */
    private Tournament tournament;
    private List<TextView> semiTextViews;
    private List<BinderTeamTextView> binderSemi;

    public TournamentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupLayout(context);
        initViews();
        updateElementsAccordingToAttributs(context, attrs);

    }

    private void initViews() {
        //init view
        mainLayout = (LinearLayout) rootView.findViewById(R.id.main);
        semiACard1Textview = (TextView) rootView.findViewById(R.id.semi_a_card_1_textview);
        semiACard2Textview = (TextView) rootView.findViewById(R.id.semi_a_card_2_textview);
        semiBCard1Textview = (TextView) rootView.findViewById(R.id.semi_b_card_1_textview);
        semiBCard2Textview = (TextView) rootView.findViewById(R.id.semi_b_card_2_textview);

        semiTextViews = new ArrayList<>();
        semiTextViews.add(semiACard1Textview);
        semiTextViews.add(semiACard2Textview);
        semiTextViews.add(semiBCard1Textview);
        semiTextViews.add(semiBCard2Textview);


    }

    public void startTournament() {
        binderSemi = new ArrayList<>();
        if (null != tournament) {
            // init binder team <=> textviews semi final and set team name's
            for (int i = 0; i < tournament.getTeams().size(); i++) {
                BinderTeamTextView binder = new BinderTeamTextView(tournament.getTeams().get(i), semiTextViews.get(i));
                // set teams names
                semiTextViews.get(i).setText(tournament.getTeams().get(i).getName());
                binderSemi.add(binder);
            }



        }
    }

    public void setupLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView = inflater.inflate(R.layout.main_layout, this);

    }

    private void updateElementsAccordingToAttributs(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.TournamentView, 0, 0);


        // Attributs
        int mainColor = typedArray.getColor(R.styleable.TournamentView_main_bg_color,
                context.getResources().getColor(R.color.cardview_shadow_start_color));
        mainLayout.setBackgroundColor(mainColor);

    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void simulate() {
    }
}
