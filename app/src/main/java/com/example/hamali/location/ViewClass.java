package com.example.hamali.location;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ViewClass extends AppCompatActivity implements Interface.venue_view {
    private TextView textView;
    private EditText editText;
    Button button;
    private LocationManager locationManager;
    private LocationListener locationListener;
    String input;
    ListView listView;
    double lat, lon;
    private Interface.venue_presentor presentor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listivew);
        button = (Button) findViewById(R.id.button);
        presentor = new Presenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = editText.getText().toString();
                if (input.isEmpty()){editText.setError("Enter Keyword");}
                else{presentor.process(input);}
            }
        });
    }


    @Override
    public void showresult(List result)

    {
        Adapter exploreList = new Adapter(getApplicationContext(), R.layout.list_view, result);
        listView.setAdapter(exploreList);
    }

    public void location() {

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (location == null){
                    boolean isNetworkenabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                    if (isNetworkenabled) {
                        requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 12);
                    }
                }
                lon = location.getLongitude();
                lat = location.getLatitude();
                presentor.locresult(toString().valueOf(lat) + "," + toString().valueOf(lon));
                textView.setText(toString().valueOf(lat)+","+toString().valueOf(lon));

            }


            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"permission not granted",Toast.LENGTH_SHORT).show();

        }
        boolean isGPSenabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (isGPSenabled) {
            requestPermissions(new String[]{Manifest.permission.INTERNET, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 10);
        }else{
            Toast.makeText(this,"Please enable GPS",Toast.LENGTH_SHORT).show();
        }
    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
                }
            case 12:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0, locationListener);
                }else{
                    Toast.makeText(this,"Please Enable Location",Toast.LENGTH_SHORT).show();
                }

        }
    }
}
