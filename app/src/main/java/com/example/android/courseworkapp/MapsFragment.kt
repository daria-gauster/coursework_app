package com.example.android.courseworkapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.checkSelfPermission

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        //default location is odesa
        val location = LatLng(46.0, 30.0)

        
        googleMap.addMarker(MarkerOptions().position(location).title("Marker in Odesa"))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))
//        googleMap.setOnMapClickListener { latLng ->
//            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
//            googleMap.addMarker(MarkerOptions().position(LatLng(latLng.latitude, latLng.longitude)))
//        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
//    private fun fetchLocation() {
//        if (ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_FINE_LOCATION) !=
//            PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
//            PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), permissionCode)
//            return
//        }
//        val task = fusedLocationProviderClient.lastLocation
//        task.addOnSuccessListener { location −>
//            if (location != null) {
//                currentLocation = location
//                Toast.makeText(applicationContext, currentLocation.latitude.toString() + "" +
//                        currentLocation.longitude, Toast.LENGTH_SHORT).show()
//                val supportMapFragment = (supportFragmentManager.findFragmentById(R.id.myMap) as
//                        SupportMapFragment?)!!
//                supportMapFragment.getMapAsync(this@MainActivity)
//            }
//        }
//    }

}