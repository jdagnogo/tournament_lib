package com.example.jdagnogo.mytournament.model.bundler;

import android.os.Bundle;

import com.example.jdagnogo.mytournament.model.Team;

import org.parceler.Parcels;

import icepick.Bundler;

public class TeamBundler implements Bundler<Team> {
    @Override
    public void put(String s, Team team, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(team));
    }

    @Override
    public Team get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}
