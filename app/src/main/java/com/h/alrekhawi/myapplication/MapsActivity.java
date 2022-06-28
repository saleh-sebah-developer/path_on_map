package com.h.alrekhawi.myapplication;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.h.alrekhawi.myapplication.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng gaza = new LatLng(31.418091, 34.369837);
        LatLng gaza2 = new LatLng(31.418272, 34.370012);
        LatLng gaza3 = new LatLng(31.4221027,34.4676943);
        mMap.addMarker(new MarkerOptions().position(gaza).title("Marker in Gaza"));
        mMap.addMarker(new MarkerOptions().position(gaza2).title("Marker in Gaza2"));
        mMap.addMarker(new MarkerOptions().position(gaza3).title("Marker in Gaza3"));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(gaza));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gaza,12));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(gaza, 12));

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.getUiSettings().setCompassEnabled(true);
        //mMap.setMyLocationEnabled(true);

        mMap.addPolyline(new PolylineOptions()
                .add(gaza)
                .add(gaza2)
                .color(Color.RED));

//        mMap.addPolygon(new PolygonOptions().
//                add(gaza)
//                .add(gaza2)
//                .add(gaza3)
//                .fillColor(Color.GREEN)
//                .strokeColor(Color.BLACK)
//                .strokeWidth(5));
//
//        mMap.addCircle(new CircleOptions()
//        .center(gaza).fillColor(Color.YELLOW).strokeColor(Color.BLUE).strokeWidth(5).radius(6000));
    }
}