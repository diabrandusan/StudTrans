package com.example.geo.studtrans;

import android.app.ActionBar;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.lang.reflect.Field;

/**
 * Created by Geo on 12/4/2014.
 */
public class Home extends FragmentActivity {

    private GoogleMap map;
    private final LatLng LOCATION_BURNABY= new LatLng(46.771289,23.585722);
    private final LatLng LOCATION_SURREY= new LatLng(46.771289,23.585722);



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();


        map.addMarker(new MarkerOptions().position(LOCATION_SURREY).title("Find me here!"));


        ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
       // createMapView();
       // addMarker();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_home,menu);
        return true;
    }




    @Override
    public boolean onMenuItemSelected(int panel, MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.about:
                Toast.makeText(Home.this,"Informatii despre aplicatie",Toast.LENGTH_LONG).show();
                break;
            case R.id.trasee:
                Toast.makeText(Home.this,"Trasee",Toast.LENGTH_LONG).show();
                Intent iii=new Intent(Home.this,Trasee.class);
                startActivity(iii);
                break;
            case R.id.favorit:
                Toast.makeText(Home.this,"Autobuz Favorit",Toast.LENGTH_LONG).show();
                Intent iin=new Intent(Home.this,Favorit.class);
                startActivity(iin);
                break;

            case R.id.notificari:
                Toast.makeText(Home.this,"Notificari",Toast.LENGTH_LONG).show();
                Intent in=new Intent(Home.this,CurrentLocation.class);
                startActivity(in);
                break;
            case R.id.myAccount:
                Toast.makeText(Home.this,"My Account",Toast.LENGTH_LONG).show();
                Intent oIntentVr=new Intent(Home.this,MyAccount.class);
                startActivity(oIntentVr);
                break;
        }

        return true;
    }



    public void onClick_City(View v)
    {
        //CameraUpdate update= CameraUpdateFactory.newLatLng(LOCATION_BURNABY);
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY, 16);
        map.animateCamera(update);
    }

    public void onClick_Burnaby(View v)
    {
        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY,14);
        map.animateCamera(update);
    }

    public void onClick_Surrey(View v)
    {
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        CameraUpdate update= CameraUpdateFactory.newLatLngZoom(LOCATION_BURNABY,16);
        map.animateCamera(update);
    }


    /**
     * Initialises the mapview
     */
    /*
    private void createMapView(){

        try {
            if(null == googleMap){
                googleMap = ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView)).getMap();


                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception){
           // Log.e("mapApp", exception.toString());
            Toast.makeText(getApplicationContext(),
                    "NullPointerException", Toast.LENGTH_SHORT).show();
        }
    }
*/

    /**
     * Adds a marker to the map
     */
    /*
    private void addMarker(){


        if(null != googleMap){
            googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(0, 0))
                            .title("Marker")
                            .draggable(true)
            );
        }
    }
    */

    }
