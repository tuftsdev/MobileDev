package edu.tufts.cs.mchow.simplegeoapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.location.LocationManager;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    // Constants
    private final int DEFAULT_GPS_MIN_TIME = 1; // in milliseconds
    private final int DEFAULT_GPS_MIN_DISTANCE = 1; // in meters

    // Flags
    private static final int MY_PERMISSIONS_ACCESS_FINE_LOCATION = 0;

    // A simple text view
    protected TextView tv;

    // Location manager
    private LocationManager lm;

    // Location listener, necessary for location manager
    private MyLocationListener ll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up location detection stuff
        lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);

        // Initialize text view
        tv = new TextView(this);
        tv.setHeight(50);

        // Set up my location listener
        ll = new MyLocationListener(this);

        /* Check permissions
           Without this, you will receiveERROR:  Caused by: java.lang.SecurityException: "gps"
           location provider requires ACCESS_FINE_LOCATION permission.

           More: http://stackoverflow.com/questions/32083913/android-gps-requires-access-fine-location-error-even-though-my-manifest-file

           Documentation: https://developer.android.com/training/permissions/requesting.html*/
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_ACCESS_FINE_LOCATION);
        }
        tv.setText("Trying to determine your location...");
        setContentView(tv);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        // Callback on permissions grant or deny screen
        Log.v("*** MainActivity", "Doing something after the permissions popup!");
        if (requestCode == MY_PERMISSIONS_ACCESS_FINE_LOCATION
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // Yay!  Now you can do request for location updates
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    DEFAULT_GPS_MIN_TIME,
                    DEFAULT_GPS_MIN_DISTANCE,
                    ll);
        }
    }
}
