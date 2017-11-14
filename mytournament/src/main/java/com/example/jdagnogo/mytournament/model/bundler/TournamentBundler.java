package com.example.jdagnogo.mytournament.model.bundler;

import android.os.Bundle;

import com.example.jdagnogo.mytournament.model.Tournament;

import org.parceler.Parcels;

import icepick.Bundler;

public class TournamentBundler implements Bundler<Tournament> {
    @Override
    public void put(String s, Tournament tournament, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(tournament));
    }

    @Override
    public Tournament get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}