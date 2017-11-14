package com.example.jdagnogo.mytournament;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jdagnogo.mytournament.anim.CustomAnim;
import com.example.jdagnogo.mytournament.enums.TournamentRound;
import com.example.jdagnogo.mytournament.model.BinderTeamTextView;
import com.example.jdagnogo.mytournament.model.Match;
import com.example.jdagnogo.mytournament.model.Team;
import com.example.jdagnogo.mytournament.model.Tournament;
import com.example.jdagnogo.mytournament.model.bundler.BinderTeamTextViewBundler;
import com.example.jdagnogo.mytournament.model.bundler.TournamentBundler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import icepick.Icepick;
import icepick.State;


public class TournamentView extends LinearLayout {
    /*
    All Views
     */
    View rootView;
    LinearLayout mainLayout;
    //semi names
    TextView semiACard1Textview, semiACard2Textview, semiBCard1Textview, semiBCard2Textview;
    CardView semiACard1, semiACard2, semiBCard1, semiBCard2;
    View semiACard1Arrow1, semiACard1Arrow2, semiACard2Arrow1, semiACard2Arrow2, semiBCard1Arrow1, semiBCard1Arrow2, semiBCard2Arrow1, semiBCard2Arrow2;
    //semi score
    EditText semiACard1TextviewScore, semiACard2TextviewScore, semiBCard1TextviewScore, semiBCard2TextviewScore;
    //final names
    TextView finalCard1Textview, finalCard2Textview;
    CardView finalCard1, finalCard2;
    View winnerArrow0;
    TextView winnerTextView;
    View finalCard1Arrow1, finalCard1Arrow0, finalCard1Arrow2, finalCard2Arrow1, finalCard2Arrow0, finalCard2Arrow2;
    //final score
    EditText finalCard1TextviewScore, finalCard2TextviewScore;


    /*
    beans
     */
    @State(TournamentBundler.class)
    Tournament tournament;
    private List<TextView> semiTextViews;
    private List<CardView> semiCards;
    private List<TextView> finalTextViews;
    private List<CardView> finalCards;
    private List<TextView> semiTextViewsScore;
    private List<TextView> finalTextViewsScore;

    HashMap<Integer, BinderTeamTextView> binderSemi;

    HashMap<Integer, BinderTeamTextView> binderfinal;
    private Context context;

    public TournamentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupLayout(context);
        initViews();
        updateElementsAccordingToAttributs(context, attrs);
    }

    @Override
    public Parcelable onSaveInstanceState() {
        return Icepick.saveInstanceState(this, super.onSaveInstanceState());
    }

    @Override
    public void onRestoreInstanceState(Parcelable state) {
        super.onRestoreInstanceState(Icepick.restoreInstanceState(this, state));
        int toto = 0;
        startTournament();
    }


    private void initViews() {
        //init view
        mainLayout = (LinearLayout) rootView.findViewById(R.id.main);
        semiACard1Textview = (TextView) rootView.findViewById(R.id.semi_a_card_1_textview);
        semiACard2Textview = (TextView) rootView.findViewById(R.id.semi_a_card_2_textview);
        semiBCard1Textview = (TextView) rootView.findViewById(R.id.semi_b_card_1_textview);
        semiBCard2Textview = (TextView) rootView.findViewById(R.id.semi_b_card_2_textview);

        semiACard1Arrow1 = (View) rootView.findViewById(R.id.semi_a_card_1_arrow_1);
        semiACard1Arrow2 = (View) rootView.findViewById(R.id.semi_a_card_1_arrow_2);
        semiACard2Arrow1 = (View) rootView.findViewById(R.id.semi_a_card_2_arrow_1);
        semiACard2Arrow2 = (View) rootView.findViewById(R.id.semi_a_card_2_arrow_2);

        semiBCard1Arrow1 = (View) rootView.findViewById(R.id.semi_b_card_1_arrow_1);
        semiBCard1Arrow2 = (View) rootView.findViewById(R.id.semi_b_card_1_arrow_2);
        semiBCard2Arrow1 = (View) rootView.findViewById(R.id.semi_b_card_2_arrow_1);
        semiBCard2Arrow2 = (View) rootView.findViewById(R.id.semi_b_card_2_arrow_2);

        semiACard1 = (CardView) rootView.findViewById(R.id.semi_a_card_1);
        semiACard2 = (CardView) rootView.findViewById(R.id.semi_a_card_2);
        semiBCard1 = (CardView) rootView.findViewById(R.id.semi_b_card_1);
        semiBCard2 = (CardView) rootView.findViewById(R.id.semi_b_card_2);

        semiACard1TextviewScore = (EditText) rootView.findViewById(R.id.semi_a_card_1_textview_score);
        semiACard1TextviewScore.addTextChangedListener(watcherSemi1);
        semiACard2TextviewScore = (EditText) rootView.findViewById(R.id.semi_a_card_2_textview_score);
        semiACard2TextviewScore.addTextChangedListener(watcherSemi1);
        semiBCard1TextviewScore = (EditText) rootView.findViewById(R.id.semi_b_card_1_textview_score);
        semiBCard1TextviewScore.addTextChangedListener(watcherSemi2);
        semiBCard2TextviewScore = (EditText) rootView.findViewById(R.id.semi_b_card_2_textview_score);
        semiBCard2TextviewScore.addTextChangedListener(watcherSemi2);

        finalCard1Textview = (TextView) rootView.findViewById(R.id.final_card_1_textview);
        finalCard2Textview = (TextView) rootView.findViewById(R.id.final_card_2_textview);

        finalCard1Arrow0 = (View) rootView.findViewById(R.id.final_card_1_arrow_0);
        finalCard1Arrow1 = (View) rootView.findViewById(R.id.final_card_1_arrow_1);
        finalCard1Arrow2 = (View) rootView.findViewById(R.id.final_card_1_arrow_2);

        finalCard2Arrow0 = (View) rootView.findViewById(R.id.final_card_2_arrow_0);
        finalCard2Arrow1 = (View) rootView.findViewById(R.id.final_card_2_arrow_1);
        finalCard2Arrow2 = (View) rootView.findViewById(R.id.final_card_2_arrow_2);

        winnerArrow0 = (View) rootView.findViewById(R.id.winner_arrow_0);

        finalCard1 = (CardView) rootView.findViewById(R.id.final_card_1);
        finalCard2 = (CardView) rootView.findViewById(R.id.final_card_2);


        winnerTextView = (TextView) rootView.findViewById(R.id.winner_textview);

        finalCard1TextviewScore = (EditText) rootView.findViewById(R.id.final_card_1_textview_score);
        finalCard1TextviewScore.addTextChangedListener(watcherfinal);
        finalCard2TextviewScore = (EditText) rootView.findViewById(R.id.final_card_2_textview_score);
        finalCard2TextviewScore.addTextChangedListener(watcherfinal);

        // semi names
        semiTextViews = new ArrayList<>();
        semiTextViews.add(semiACard1Textview);
        semiTextViews.add(semiACard2Textview);
        semiTextViews.add(semiBCard1Textview);
        semiTextViews.add(semiBCard2Textview);

        // semi cards
        semiCards = new ArrayList<>();
        semiCards.add(semiACard1);
        semiCards.add(semiACard2);
        semiCards.add(semiBCard1);
        semiCards.add(semiBCard2);


        // final names
        finalTextViews = new ArrayList<>();
        finalTextViews.add(finalCard1Textview);
        finalTextViews.add(finalCard2Textview);

        finalCards = new ArrayList<>();
        finalCards.add(finalCard1);
        finalCards.add(finalCard2);

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
        binderfinal = new HashMap<>();
        if (null != tournament) {
            // init binder team <=> textviews semi final and set team name's
            for (int i = 0; i < tournament.getTeams().size(); i++) {
                BinderTeamTextView binder = new BinderTeamTextView(tournament.getTeams().get(i),
                        semiTextViews.get(i), semiTextViewsScore.get(i),
                        semiCards.get(i));
                // set teams names
                semiTextViews.get(i).setText(tournament.getTeams().get(i).getName());
                binderSemi.put(i, binder);
            }

        }
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
        winner.getCardView().setBackground(getResources().getDrawable(R.drawable.winner_green_bg));
        winner.getTextViewName().setTypeface(null, Typeface.BOLD);


        loser.getTextViewName().setTypeface(null, Typeface.NORMAL);
        loser.getCardView().setBackground(getResources().getDrawable(R.drawable.loser_red_bg));
    }

    private Team updateScoreandGetWinner(BinderTeamTextView semi1, BinderTeamTextView semi2, TournamentRound tournamentRound) {
        if (null != semi1 && null != semi2) {
            if (!semi1.getTextViewScore().getText().toString().isEmpty() && !semi2.getTextViewScore().getText().toString().isEmpty()) {
                Match match = new Match.MatchResultBuilder(semi1.getTeam(), semi2.getTeam())
                        .scoreA(Integer.valueOf(semi1.getTextViewScore().getText().toString()))
                        .scoreB(Integer.valueOf(semi2.getTextViewScore().getText().toString()))
                        .currentPosition(tournamentRound)
                        .build();
                Team winner = match.getWinner();
                tournament.addMatch(match);
                if (null != winner) {
                    if (winner.equals(semi1.getTeam())) {
                        setColorsBgForLoserAndWinner(semi1, semi2);
                    } else {
                        setColorsBgForLoserAndWinner(semi2, semi1);
                    }
                    return winner;
                }
            }
        }
        return null;
    }

    private TextWatcher watcherSemi1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (null != binderSemi) {
                Team team = updateScoreandGetWinner(binderSemi.get(0), binderSemi.get(1), TournamentRound.SemiA);
                if (null != team) {
                    BinderTeamTextView binderTeamTextView = new BinderTeamTextView(team, finalCard1Textview,
                            finalCard1TextviewScore, finalCard1);
                    binderfinal.put(0, binderTeamTextView);
                    finalCard1Textview.setText(team.getName());
                    CustomAnim.NextRoundAnim(finalCard1);
                }
                updateFinal();
            }

        }
    };
    private TextWatcher watcherSemi2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (null != binderSemi) {
                Team team = updateScoreandGetWinner(binderSemi.get(2), binderSemi.get(3), TournamentRound.SemiB);
                if (null != team) {
                    BinderTeamTextView binderTeamTextView = new BinderTeamTextView(team,
                            finalCard2Textview, finalCard2TextviewScore, finalCard2);
                    binderfinal.put(1, binderTeamTextView);
                    finalCard2Textview.setText(team.getName());
                    CustomAnim.NextRoundAnim(finalCard2);
                }
                updateFinal();
            }
        }
    };

    private void updateFinal() {
        if (null != binderfinal) {
            Team team = updateScoreandGetWinner(binderfinal.get(0), binderfinal.get(1), TournamentRound.Final);
            if (null != team) {
                winnerTextView.setText(team.getName());
                winnerTextView.setBackgroundColor(context.getResources().getColor(R.color.winner));
                CustomAnim.NextRoundAnim(winnerTextView);
            }

        }
    }

    private TextWatcher watcherfinal = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            updateFinal();
        }
    };

    public HashMap<TournamentRound, Match> tournamentResult() {
        return tournament.tournamentResult();
    }

    public void simulate() {
        Match semiA = tournament.getSemiAMatch();
        semiACard1TextviewScore.setText(String.valueOf(semiA.getScoreA()));
        semiACard2TextviewScore.setText(String.valueOf(semiA.getScoreB()));

        Match semiB = tournament.getSemiBMatch();
        semiBCard1TextviewScore.setText(String.valueOf(semiB.getScoreA()));
        semiBCard2TextviewScore.setText(String.valueOf(semiB.getScoreB()));

        Match finalMatch = tournament.getFinalMatch();
        finalCard1TextviewScore.setText(String.valueOf(finalMatch.getScoreA()));
        finalCard2TextviewScore.setText(String.valueOf(finalMatch.getScoreB()));
    }

    public void setupLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        rootView = inflater.inflate(R.layout.main_layout, this);

    }
}
