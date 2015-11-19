package com.loginext.loginext;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Nitish on 19-11-2015.
 */
public class Locfetching extends Service {

    LocationManager locationManager;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("2", "2");
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        MyLocationListener myLocationListener = new MyLocationListener();

        // request location every 120,000 ms = 2 min
        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, myLocationListener);

        } else if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1, myLocationListener);
        }

        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (location != null) {
            Log.e("SERVICE123", "LATITUDE:- "+ location.getLatitude() + " Longitude:- " + location.getLongitude());
        }

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("1", "1");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("3", "3");
        if (locationManager != null) {
            locationManager = null;
        }
    }

    public class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            // TODO Auto-generated method stub
            Log.e("SERVICE", "LATITUDE:- "+ location.getLatitude() + " Longitude:- " + location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub

        }

    }   }
