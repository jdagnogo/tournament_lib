package com.example.jdagnogo.mytournament.model.bundler;

import android.os.Bundle;

import com.example.jdagnogo.mytournament.model.Match;
import org.parceler.Parcels;
import icepick.Bundler;

public class MatchBundler implements Bundler<Match> {
    @Override
    public void put(String s, Match match, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(match));
    }

    @Override
    public Match get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}