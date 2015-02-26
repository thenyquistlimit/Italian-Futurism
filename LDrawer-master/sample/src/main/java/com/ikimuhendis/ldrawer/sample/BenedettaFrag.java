package com.ikimuhendis.ldrawer.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.squareup.picasso.Picasso;

public class BenedettaFrag extends Fragment
{
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get Analytics v4 Tracker.
        Tracker t = ((MyApplication) getActivity().getApplication()).getTracker(
                MyApplication.TrackerName.APP_TRACKER);

        // Set screen name.
        t.setScreenName("Benedetta Cappa");

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAutoActivityTracking(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.benedettafrag, container, false);

        ImageView i = (ImageView) rootView.findViewById(R.id.imageView_round);
        ImageView i2 = (ImageView) rootView.findViewById(R.id.profile_background);

        Picasso.with(getActivity())
                .load("http://www.150anni.it/webi/_file/immagini/italiane/019-cappa2.jpg")
                .into(i);

        Picasso.with(getActivity())
                .load("http://www.ansa.it/webimages/foto_large_ls_350/2014/1/17/8db5ed6f52f10165cc3855c93704d0d6.jpg")
                .into(i2);

        getActivity().setTitle("Benedetta Cappa");
        return rootView;
    }

    @Override
    public void onStart()
    {
        super.onStart();
        GoogleAnalytics.getInstance(getActivity()).reportActivityStart(getActivity());
    }

    @Override
    public void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(getActivity()).reportActivityStop(getActivity());
    }

}

