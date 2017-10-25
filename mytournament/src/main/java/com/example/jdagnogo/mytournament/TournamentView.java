package com.example.jdagnogo.mytournament;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


public class TournamentView extends LinearLayout {
    /*
    All Views
     */
    View rootView;
    LinearLayout mainLayout;


    /*
    beans
     */
    private Tournament tournament;

    public TournamentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setupLayout(context);
        updateElementsAccordingToAttributs(context,attrs);
    }

    public void setupLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rootView= inflater.inflate(R.layout.main_layout, this);

    }

    private void updateElementsAccordingToAttributs(Context context,@Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.TournamentView, 0, 0);
        mainLayout = (LinearLayout)rootView.findViewById(R.id.main);
        int mainColor = typedArray.getColor(R.styleable.TournamentView_main_bg_color,
                context.getResources().getColor(R.color.cardview_shadow_start_color));
        mainLayout.setBackgroundColor(mainColor);

    }

    public void updateTournament() {

    }

}
