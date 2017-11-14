package com.example.jdagnogo.mytournament.model.bundler;

import android.os.Bundle;

import com.example.jdagnogo.mytournament.model.BinderTeamTextView;

import org.parceler.Parcels;

import icepick.Bundler;

public class BinderTeamTextViewBundler implements Bundler<BinderTeamTextView> {
    @Override
    public void put(String s, BinderTeamTextView match, Bundle bundle) {
        bundle.putParcelable(s, Parcels.wrap(match));
    }

    @Override
    public BinderTeamTextView get(String s, Bundle bundle) {
        return Parcels.unwrap(bundle.getParcelable(s));
    }
}
