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

public class CarloFrag extends Fragment
{
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get Analytics v4 Tracker.
        Tracker t = ((MyApplication) getActivity().getApplication()).getTracker(
                MyApplication.TrackerName.APP_TRACKER);

        // Set screen name.
        t.setScreenName("Carlo Carra");

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAutoActivityTracking(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.carlofrag, container, false);

        ImageView i = (ImageView) rootView.findViewById(R.id.imageView_round);
        ImageView i2 = (ImageView) rootView.findViewById(R.id.profile_background);

        Picasso.with(getActivity())
                .load("http://uploads4.wikiart.org/temp/08703cb2-8977-4723-9dce-e07f5dfa882f.jpg")
                .into(i);

        Picasso.with(getActivity())
                .load("http://www.artinvest2000.com/carra-artist.jpg")
                .into(i2);

        getActivity().setTitle("Carlo Carra");
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
