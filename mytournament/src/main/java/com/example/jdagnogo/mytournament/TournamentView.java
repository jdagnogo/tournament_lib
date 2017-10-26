package com.example.jdagnogo.mytournament;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdagnogo.mytournament.model.BinderTeamTextView;
import com.example.jdagnogo.mytournament.model.MatchResult;
import com.example.jdagnogo.mytournament.model.Tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class TournamentView extends LinearLayout implements View.OnClickListener {
    /*
    All Views
     */
    View rootView;
    LinearLayout mainLayout;
    //semi names
    TextView semiACard1Textview, semiACard2Textview, semiBCard1Textview, semiBCard2Textview;
    //semi score
    EditText semiACard1TextviewScore, semiACard2TextviewScore, semiBCard1TextviewScore, semiBCard2TextviewScore;
    //final names
    TextView finalCard1Textview, finalCard2Textview;
    //final score
    EditText finalCard1TextviewScore, finalCard2TextviewScore;


    /*
    beans
     */
    private Tournament tournament;
    private List<TextView> semiTextViews;
    private List<TextView> finalTextViews;
    private List<TextView> semiTextViewsScore;
    private List<TextView> finalTextViewsScore;
    private HashMap<Integer, BinderTeamTextView> binderSemi;

    private Context context;

    public TournamentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
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

        semiACard1TextviewScore = (EditText) rootView.findViewById(R.id.semi_a_card_1_textview_score);
        semiACard2TextviewScore = (EditText) rootView.findViewById(R.id.semi_a_card_2_textview_score);
        semiBCard1TextviewScore = (EditText) rootView.findViewById(R.id.semi_b_card_1_textview_score);
        semiBCard2TextviewScore = (EditText) rootView.findViewById(R.id.semi_b_card_2_textview_score);

        finalCard1Textview = (TextView) rootView.findViewById(R.id.final_card_1_textview);
        finalCard1Textview.setOnClickListener(this);
        finalCard2Textview = (TextView) rootView.findViewById(R.id.final_card_2_textview);
        finalCard2Textview.setOnClickListener(this);

        finalCard1TextviewScore = (EditText) rootView.findViewById(R.id.final_card_1_textview_score);
        finalCard2TextviewScore = (EditText) rootView.findViewById(R.id.final_card_2_textview_score);

        // semi names
        semiTextViews = new ArrayList<>();
        semiTextViews.add(semiACard1Textview);
        semiTextViews.add(semiACard2Textview);
        semiTextViews.add(semiBCard1Textview);
        semiTextViews.add(semiBCard2Textview);

        // final names
        finalTextViews = new ArrayList<>();
        finalTextViews.add(finalCard1Textview);
        finalTextViews.add(finalCard2Textview);

        // semi scnore
        semiTextViewsScore = new ArrayList<>();
        semiTextViewsScore.add(semiACard1TextviewScore);
        semiTextViewsScore.add(semiACard2TextviewScore);
        semiTextViewsScore.add(semiBCard1TextviewScore);
        semiTextViewsScore.add(semiBCard2TextviewScore);

        // final scnore
        finalTextViewsScore = new ArrayList<>();
        finalTextViewsScore.add(finalCard1TextviewScore);
        finalTextViewsScore.add(finalCard2TextviewScore);


    }

    public void startTournament() {
        binderSemi = new HashMap<>();
        if (null != tournament) {
            // init binder team <=> textviews semi final and set team name's
            for (int i = 0; i < tournament.getTeams().size(); i++) {
                BinderTeamTextView binder = new BinderTeamTextView(tournament.getTeams().get(i), semiTextViews.get(i), semiTextViewsScore.get(i));
                // set teams names
                semiTextViews.get(i).setText(tournament.getTeams().get(i).getName());
                binderSemi.put(i, binder);
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

    private void setColorsBgForLoserAndWinner(BinderTeamTextView winner, BinderTeamTextView loser) {
        winner.getTextViewName().setBackgroundColor(context.getResources().getColor(R.color.winner));
        loser.getTextViewName().setBackgroundColor(context.getResources().getColor(R.color.loser));
    }

    private void updateScore(BinderTeamTextView semi1, BinderTeamTextView semi2, TextView textView) {
        if (!semi1.getTextViewScore().getText().toString().isEmpty() && !semi2.getTextViewScore().getText().toString().isEmpty()) {
            MatchResult matchResult = new MatchResult.MatchResultBuilder(semi1.getTeam(), semi2.getTeam())
                    .scoreA(Integer.valueOf(semi1.getTextViewScore().getText().toString()))
                    .scoreB(Integer.valueOf(semi2.getTextViewScore().getText().toString()))
                    .build();
            if (matchResult.getWinner().equals(semi1.getTeam())) {
                setColorsBgForLoserAndWinner(semi1, semi2);
            } else {
                setColorsBgForLoserAndWinner(semi2, semi1);
            }

            textView.setText(matchResult.getWinner().getName());

        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.final_card_1_textview) {
            updateScore(binderSemi.get(0), binderSemi.get(1), finalCard1Textview);
        } else if (id == R.id.final_card_2_textview) {
            updateScore(binderSemi.get(2), binderSemi.get(3), finalCard2Textview);
        }
    }
}
