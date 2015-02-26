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

public class GinoFrag extends Fragment
{
    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get Analytics v4 Tracker.
        Tracker t = ((MyApplication) getActivity().getApplication()).getTracker(
                MyApplication.TrackerName.APP_TRACKER);

        // Set screen name.
        t.setScreenName("Gino Severini");

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());
        t.enableAutoActivityTracking(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.ginofrag, container, false);

        ImageView i = (ImageView) rootView.findViewById(R.id.imageView_round);
        ImageView i2 = (ImageView) rootView.findViewById(R.id.profile_background);

        Picasso.with(getActivity())
                .load("http://2.bp.blogspot.com/-STAh5Ms32VQ/T0qG4291z1I/AAAAAAAAEGI/nvriSUbKG0M/s1600/severini+8.gif")
                .into(i);

        Picasso.with(getActivity())
                .load("http://thumbs.media.smithsonianmag.com//filer/20120424025011Articulations-Armored-Train-in-Action-470.jpg__800x600_q85_crop.jpg")
                .into(i2);

        getActivity().setTitle("Gino Severini");
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

