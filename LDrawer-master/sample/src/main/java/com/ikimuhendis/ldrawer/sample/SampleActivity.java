package com.ikimuhendis.ldrawer.sample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;

import java.util.ArrayList;
import java.util.List;

import static com.ikimuhendis.ldrawer.sample.R.id.action_map;
import static com.ikimuhendis.ldrawer.sample.R.id.action_websearch;

import com.google.android.gms.analytics.GoogleAnalytics;

public class SampleActivity extends Activity
{
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    List<DrawerItem> dataList;
    CustomDrawerAdapter adapter;
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

        Fragment onstart = new ItalianFrag();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, onstart);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();

        dataList = new ArrayList<DrawerItem>();
        dataList.add(new DrawerItem("Italian Futurism", R.drawable.bomb));
        dataList.add(new DrawerItem("Fillipo T. Marinetti", R.drawable.manb));
        dataList.add(new DrawerItem("Umberto Boccioni", R.drawable.star));
        dataList.add(new DrawerItem("Luigi Russolo", R.drawable.urn));
        dataList.add(new DrawerItem("Antonio Sant'Elia", R.drawable.build));
        dataList.add(new DrawerItem("Gino Severini", R.drawable.side));
        dataList.add(new DrawerItem("Giocomo Balla", R.drawable.bug));
        dataList.add(new DrawerItem("Bruno Munari", R.drawable.paperp));
        dataList.add(new DrawerItem("Benedetta Cappa", R.drawable.glass));
        dataList.add(new DrawerItem("Carlo Carra", R.drawable.fire));
        dataList.add(new DrawerItem("Francesco B. Pratella", R.drawable.ironb));
        dataList.add(new DrawerItem("Fortunato Depero", R.drawable.handfeed));
        dataList.add(new DrawerItem("Bruno Corra", R.drawable.mason));

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.navdrawer);

        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                drawerArrow, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        adapter = new CustomDrawerAdapter(this, R.layout.custom_drawer_item, dataList);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // update the main content by replacing fragments
                Fragment fragment = null;
                Bundle args = new Bundle();
                switch (position) {
                    case 0:
                        fragment = new ItalianFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 1:
                        fragment = new FillipoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 2:
                        fragment = new UmbertoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 3:
                        fragment = new LuigiFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 4:
                        fragment = new AntonioFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 5:
                        fragment = new GinoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 6:
                        fragment = new GiocomoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 7:
                        fragment = new BrunoMFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 8:
                        fragment = new BenedettaFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 9:
                        fragment = new CarloFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 10:
                        fragment = new FrancescoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 11:
                        fragment = new FortunatoFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 12:
                        fragment = new BrunoCFrag();
                        mDrawerToggle.setAnimateEnabled(true);
                        drawerArrow.setProgress(1f);
                        mDrawerToggle.syncState();
                        break;
                    case 13:
                        Intent share = new Intent(Intent.ACTION_SEND);
                        share.setType("text/plain");
                        share.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        share.putExtra(Intent.EXTRA_SUBJECT,
                                getString(R.string.app_name));
                        share.putExtra(Intent.EXTRA_TEXT, getString(R.string.app_description) + "\n" +
                                "GitHub Page :  https://github.com/IkiMuhendis/LDrawer\n" +
                                "Sample App : https://play.google.com/store/apps/details?id=" +
                                getPackageName());
                        startActivity(Intent.createChooser(share,
                                getString(R.string.app_name)));
                        break;
                    case 14:
                        String appUrl = "https://play.google.com/store/apps/details?id=" + getPackageName();
                        Intent rateIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(appUrl));
                        startActivity(rateIntent);
                        break;
                }

                fragment.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment).addToBackStack(null).commit();
                // update selected item and title, then close the drawer
                mDrawerList.setItemChecked(position, true);
                setTitle(dataList.get(position).getItemName());
                mDrawerLayout.closeDrawer(mDrawerList);

            }
        });
    }

    @Override
    public void setTitle(CharSequence title)
    {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * Called whenever we call invalidateOptionsMenu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        // If the nav drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        menu.findItem(R.id.action_map).setVisible(!drawerOpen);
        /*menu.findItem(R.id.menu_item_share).setVisible(!drawerOpen);*/
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == android.R.id.home)
        {
            if (mDrawerLayout.isDrawerOpen(mDrawerList))
            {
                mDrawerLayout.closeDrawer(mDrawerList);
            }
            else
            {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        }

        switch (item.getItemId())
        {
            case action_map:
                Intent intent2 = new Intent(this, MapActivity.class);
                startActivity(intent2);
                break;

            /*case R.id.menu_item_share:
                // Fetch and store ShareActionProvider
                mShareActionProvider = (ShareActionProvider) item.getActionProvider();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;*/

            case action_websearch:
                // create intent to perform web search
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, getActionBar().getTitle());
                // catch event that there's no activity to handle intent
                if (intent.resolveActivity(getPackageManager()) != null)
                {
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
                }
                return true;

            default:
                break;
        }
        return false;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}

