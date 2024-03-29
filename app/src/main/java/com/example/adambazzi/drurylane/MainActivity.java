package com.example.adambazzi.drurylane;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                    MainFragment.OnFragmentInteractionListener,
                    premadeMenu.OnFragmentInteractionListener,
                    createCakeFragment.OnFragmentInteractionListener,
                    AboutFragment.OnFragmentInteractionListener,
                    CreditsFragment.OnFragmentInteractionListener,
                    ReviewFragment.OnFragmentInteractionListener,
                    ReviewInformationFragment.OnFragmentInteractionListener,
                    SocialFragment.OnFragmentInteractionListener,
                    SettingsFragment.OnFragmentInteractionListener {

        FragmentManager fm;
        FragmentTransaction transaction;

        private static final String TAG = "MainActivity";
        private static final int ERROR_DIALOG_REQUEST = 9001;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.replace(R.id.content, new MainFragment());
            transaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


        @Override
        public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            transaction = fm.beginTransaction();
            transaction.replace(R.id.content, new SettingsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }

        return super.onOptionsItemSelected(item);
    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
        // Handle navigation view item clicks here.
        int id = item.getItemId();

            transaction = fm.beginTransaction();
            transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_back_in, R.anim.fade_back_out);
            if (id == R.id.custom_cake) {
            transaction.replace(R.id.content, new createCakeFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.premade_dessert) {
            transaction.replace(R.id.content, new MainFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.about_us) {
            FragmentManager fm = getSupportFragmentManager();
            transaction.replace(R.id.content, new AboutFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.credits) {
            FragmentManager fm = getSupportFragmentManager();
            transaction.replace(R.id.content, new CreditsFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.reviews){
                FragmentManager fm = getSupportFragmentManager();
                transaction.replace(R.id.content, new ReviewFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }else if (id == R.id.social){
                FragmentManager fm = getSupportFragmentManager();
                transaction.replace(R.id.content, new SocialFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

        @Override
        public void onFragmentInteraction (Uri uri){

    }
}

