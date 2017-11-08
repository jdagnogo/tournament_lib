package com.example.jdagnogo.mytournament.anim;

import android.view.View;

import com.appolica.flubber.Flubber;

public class CustomAnim {

    public static void NextRoundAnim(View view){
        Flubber.with()
                .animation(Flubber.AnimationPreset.MORPH)
                .repeatCount(1)
                .duration(1000)
                .createFor(view)
                .start();
    }
}
