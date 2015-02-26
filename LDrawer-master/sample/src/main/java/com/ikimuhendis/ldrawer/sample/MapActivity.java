package com.ikimuhendis.ldrawer.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

//Google Maps
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MapActivity extends Activity
{
    private GoogleMap mMap;
    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();
    private HashMap<Marker, MyMarker> mMarkersHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);

        ((MyApplication) getApplication()).getTracker(MyApplication.TrackerName.APP_TRACKER);

        // Initialize the HashMap for Markers and MyMarker object
        mMarkersHashMap = new HashMap<Marker, MyMarker>();

        mMyMarkersArray.add(new MyMarker("Ristorante Savini - The original Futurist Manifesto written here (Milan)", "icon1",
                Double.parseDouble("45.465711"), Double.parseDouble("9.190654")));
        mMyMarkersArray.add(new MyMarker("Luigi Russolo - Birthplace (Portogruaro)", "icon2",
                Double.parseDouble("45.778488"), Double.parseDouble("12.837211")));
        mMyMarkersArray.add(new MyMarker("Antonio Sant'Elia - Birthplace (Como)", "icon3",
                Double.parseDouble("45.810408"), Double.parseDouble("9.083712")));
        mMyMarkersArray.add(new MyMarker("Gino Severini - Birthplace (Cortona)", "icon4",
                Double.parseDouble("43.273425"), Double.parseDouble("11.989143")));
        mMyMarkersArray.add(new MyMarker("Umberto Boccioni - Birthplace (Reggio Calabria)", "icon5",
                Double.parseDouble("38.085318"), Double.parseDouble("16.149563")));
        mMyMarkersArray.add(new MyMarker("Giacomo Balla - Birthplace (Turin)", "icon6",
                Double.parseDouble("45.047641"), Double.parseDouble("7.625238")));
        mMyMarkersArray.add(new MyMarker("Benedetta Cappa - Birthplace (Rome)", "icon7",
                Double.parseDouble("41.902661"), Double.parseDouble("12.497546")));
        mMyMarkersArray.add(new MyMarker("Carlo Carra - Birthplace (Quargnento)", "icon8",
                Double.parseDouble("44.947040"), Double.parseDouble("8.487284")));
        mMyMarkersArray.add(new MyMarker("Bruno Munari - Birthplace (Milan)", "icon11",
                Double.parseDouble("45.483559"), Double.parseDouble("9.158849")));
        mMyMarkersArray.add(new MyMarker("Francesco B. Pratella - Birthplace (Lugo)", "icon13",
                Double.parseDouble("44.422238"), Double.parseDouble("11.908248")));
        mMyMarkersArray.add(new MyMarker("Fortunato Depero - Birthplace (Fondo, Malosco)", "icon12",
                Double.parseDouble("46.435643"), Double.parseDouble("11.144354")));
        mMyMarkersArray.add(new MyMarker("Bruno Corra - Birthplace (Ravenna)", "icon10",
                Double.parseDouble("44.415346"), Double.parseDouble("12.196218")));

        setUpMap();
        plotMarkers(mMyMarkersArray);
        // Perform any camera updates here
    }

    @Override
    public void onStart()
    {
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }

    @Override
    public void onStop()
    {
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            for (MyMarker myMarker : markers)
            {
                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.mapiconb));
                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);
                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }

    private int manageMarkerIcon(String markerIcon)
    {
        if (markerIcon.equals("icon1"))
            return R.drawable.bomb;
        else if(markerIcon.equals("icon2"))
            return R.drawable.urn;
        else if(markerIcon.equals("icon3"))
            return R.drawable.build;
        else if(markerIcon.equals("icon4"))
            return R.drawable.side;
        else if(markerIcon.equals("icon5"))
            return R.drawable.star;
        else if(markerIcon.equals("icon6"))
            return R.drawable.bug;
        else if(markerIcon.equals("icon7"))
            return R.drawable.glass;
        else if(markerIcon.equals("icon8"))
            return R.drawable.fire;
        else if(markerIcon.equals("icon9"))
            return R.drawable.manb;
        else if(markerIcon.equals("icon10"))
            return R.drawable.mason;
        else if(markerIcon.equals("icon11"))
            return R.drawable.paperp;
        else if(markerIcon.equals("icon12"))
            return R.drawable.handfeed;
        else if(markerIcon.equals("icon13"))
            return R.drawable.ironb;
        else
            return R.drawable.tower;
    }

    private void setUpMap()
    {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null)
        {
            // Try to obtain the map from the Map Fragment.
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

            //Setting Up Camera Location, Zoom, Tilt, and Bearing Points
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(new LatLng(41.973990, 13.738162)).zoom(6).bearing(340).tilt(45).build();

            //Animate from starting position
            mMap.animateCamera(CameraUpdateFactory
                    .newCameraPosition(cameraPosition));

            // Check if we were successful in obtaining the map.
            if (mMap != null)
            {
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                {
                    @Override
                    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker)
                    {
                        marker.showInfoWindow();
                        return true;
                    }
                });
            }
            else
                Toast.makeText(getApplicationContext(), "Unable to create Maps", Toast.LENGTH_SHORT).show();
        }
    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        public MarkerInfoWindowAdapter()
        {}

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker)
        {
            View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);
            MyMarker myMarker = mMarkersHashMap.get(marker);
            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);
            TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);
            /*TextView anotherLabel = (TextView)v.findViewById(R.id.another_label);
            anotherLabel.setText("A custom text");*/
            markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));
            markerLabel.setText(myMarker.getmLabel());
            return v;
        }
    }
}