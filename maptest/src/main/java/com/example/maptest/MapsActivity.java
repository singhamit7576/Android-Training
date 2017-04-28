package com.example.maptest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Create Activity which extends FragmentActivity
 * and implements Google Map interfaces.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener,
        GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private List<LatLng> polygon = new ArrayList<>();
    private ArrayList<LatLngBean> list;
    private  int width;
    private int height;


    /**
     * Activity Created .
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment      =   (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        this.setMarkerInList();
        // mMap.setOnMapClickListener(this);//this. method for create Marker On Map Click.
        mMap.setOnMarkerClickListener(this);
        this.zoomMap();
        // this.addMarkerWithCustomIcon();  //This Method for set Marker With Custom Icon.
        // this.AddInfoWindow();               //This Method for Show MArker With flag.

    }


    /**
     * set Markers In
     * List/
     */
    private void setMarkerInList() {
        list = new ArrayList<>();
        list.add(new LatLngBean(getString(R.string.noida),28.542622,77.385760 ,getString(R.string.hello)));
        list.add(new LatLngBean(getString(R.string.ajmer),27.086690,72.827181,getString(R.string.hello)));
        list.add( new LatLngBean(getString(R.string.indore),22.737943,75.947297,getString(R.string.hello)));
        loadingMarker(list);
    }

    /**
     * add Marker.
     * @param list
     */
    private void loadingMarker(ArrayList<LatLngBean> list) {

        for(int  i = 0 ; i  < list.size() ; i++){
            LatLngBean bean     =    list.get(i);
            String id = this.setMarkerWithBitmap(bean);
            list.get(i).setId(id);
        }
    }


    /**
     * use Bitmap And get Image From drawable Folder.
     * @param bean
     * @return
     */
    private String setMarkerWithBitmap(LatLngBean bean) {

        Bitmap bitmap1                =        BitmapFactory.decodeResource(getResources(),R.drawable.redcurved);
        Bitmap bitmap2                =        BitmapFactory.decodeResource(getResources(),R.drawable.indecation_bg);
        BitmapDescriptor markerIcon   =         markerBitmapDescriptor(bitmap1 ,bitmap2 ,bean.getTitle(),bean.getSnippet() );
        Marker marker                 =        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(bean.getLatitude(),bean.getLongitude()))
                .title(bean.getTitle()).icon(markerIcon));
        return marker.getId();
    }

    /**
     * In this Method,pass Bitmap1 and Bitmap2
     * and Title And Snippet.
     * which set as text.
     * @param bitmap1
     * @param bitmap2
     * @param beanTitle
     * @param title
     * @return
     */
    private BitmapDescriptor markerBitmapDescriptor(Bitmap bitmap1, Bitmap bitmap2, String beanTitle, String title) {
        setupWidthHeight(bitmap1,bitmap2);
        Bitmap.Config conf       =      Bitmap.Config.ARGB_8888;
        Bitmap mBitmap           =      Bitmap.createBitmap(width,height,conf);
        Canvas canvas1           =      new Canvas(mBitmap);
        Paint paint              =      getPaint();
        canvas1.drawBitmap(bitmap1,0,0, paint);
        canvas1.drawBitmap(bitmap2,0,bitmap1.getHeight(), paint);
        this.setTextOnMarker(canvas1,beanTitle,title,paint);
        return BitmapDescriptorFactory.fromBitmap(mBitmap);
    }

    /**
     * setUp Height And Width.
     * @param bitmap1
     * @param bitmap2
     */
    private void setupWidthHeight(Bitmap bitmap1, Bitmap bitmap2) {

        height =  bitmap1.getHeight()    +   bitmap2.getHeight();
        if(bitmap1.getWidth()   >   bitmap2.getWidth()){
            width   =   bitmap2.getWidth();
        }
        else{
            width   = bitmap1.getWidth();
        }
    }


    /**
     * set text.
     * @param canvas1
     * @param beanTitle
     * @param title
     * @param paint
     */
    private void setTextOnMarker(Canvas canvas1, String beanTitle, String title, Paint paint) {
        canvas1.drawText(beanTitle, 50, 50, paint);
        canvas1.drawText(title, 50, 120, paint);
    }

    /**
     * Create New Paint with
     * Default setting .
     * set TExt color,size.
     * @return
     */
    private Paint getPaint() {
        Paint mPaint = new Paint();
        mPaint.setTextSize(30);
        mPaint.setTextAlign(Paint.Align.LEFT );
        mPaint.setColor(Color.WHITE);
        return mPaint;
    }


    /**
     * On Marker Click
     * show the list Title.
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {

        for(int  i = 0 ; i < list.size() ;i++){
            if(list.get(i).getId().equals(marker.getId())){
                Toast.makeText(MapsActivity.this, list.get(i).getTitle(), Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

    /**
     * method which
     * for Zoomm In Andf Zoom Out.
     */
    private void zoomMap() {
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }


    /**
     * Set Marker And position
     * on user click on map.and
     * show location on Marker click.
     * @param latLng
     */
    @Override
    public void onMapClick(LatLng latLng) {
        MarkerOptions markerOptions         =   new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title(getLocation(latLng.latitude,latLng.longitude));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.addMarker(markerOptions);
        this.drawPolygon(latLng);
    }


    /**
     * Method ,In which set
     * ployLine with Marker.
     * @param latLng
     */
    private void drawPolygon(LatLng latLng) {
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(Color.RED);
        polylineOptions.width(3);
        polygon.add(latLng);
        polylineOptions.addAll(polygon);
        mMap.addPolyline(polylineOptions);
    }


    /**
     * Method in which
     * get the Country Name And
     * Address.
     * @param lat
     * @param lng
     * @return
     */
    public String getLocation(double lat, double lng) {
        Geocoder geocoder               =   new Geocoder(MapsActivity.this, Locale.getDefault());
        String add="";
        try {
            List<Address> addresses     =       geocoder.getFromLocation(lat, lng, 1);
            if (addresses.size()        ==   0) {
                Toast.makeText(MapsActivity.this, ""+getResources().getString(R.string.location), Toast.LENGTH_SHORT).show();
            }
            else {
                Address object   =  addresses.get(0);
                add             +=  object.getAddressLine(0) + ",";
                add             +=  object.getLocality() + ",";
                add             +=  object.getCountryName();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return add;
    }


    /**
     * Set marker With Custom
     * Custom Icon.
     */
    private void addMarkerWithCustomIcon() {

        LatLng noida                =       new LatLng(28.542622, 77.385760);
        mMap.addMarker(new MarkerOptions().position(noida).title(getResources().getString(R.string.noida))
                .snippet(getResources().getString(R.string.uttar_pradesh)).icon(  BitmapDescriptorFactory.fromResource(R.drawable.largeredicon)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(27.086690, 72.827181)).title(getResources().getString(R.string.ajmer))
                .snippet(getResources().getString(R.string.rajasthan)).icon(BitmapDescriptorFactory.fromResource(R.drawable.blueicon)));
        mMap.addMarker(new MarkerOptions().position(new LatLng(22.737943, 75.947297)).title(getResources().getString(R.string.indore))
                .snippet(getResources().getString(R.string.madhya_pradesh)).icon(BitmapDescriptorFactory.fromResource(R.drawable.blueicon)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(noida));
        //this.coverArea();


    }

    /**
     * draw Polyline and cover Area.
     * with With Specified LatLng.
     */
    private void coverArea() {
        List<LatLng> polygon = new ArrayList<>();
        polygon.add(new LatLng(28.542622, 77.385760));
        polygon.add(new LatLng(27.086690, 72.827181));
        polygon.add(new LatLng(22.737943, 75.947297));

        mMap.addPolygon(new PolygonOptions()
                .addAll(polygon)
                .fillColor(Color.parseColor("#3bb2d0")));
    }


    /**
     * Method for set InfoWindow
     * set flag on marker click.
     */

//    private void AddInfoWindow() {
//        this.mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(19.021923, 73.134658))
//                .anchor(0.5f, 0.5f)
//                .title("India"));
//        this.mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(28.340310, 84.148799))
//                .anchor(0.5f, 0.5f)
//                .title("nepal"));
//        this.mMap.addMarker(new MarkerOptions()
//                .position(new LatLng(23.915027, 90.329992))
//                .anchor(0.5f, 0.5f)
//                .title("Bangladesh"));
//        //   this.setInfoWindowAdapter();
//    }

//    private void setInfoWindowAdapter() {
//
//        this.mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
//            @Nullable
//            @Override
//            public View getInfoWindow(@Nullable Marker marker) {
//
//                LinearLayout parent     =        new LinearLayout(MapsActivity.this);
//                parent.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT));
//                parent.setOrientation(LinearLayout.VERTICAL);
//                ImageView countryFlagImage = new ImageView(MapsActivity.this);
//                switch (marker.getTitle()) {
//
//                    case "India":
//                        countryFlagImage.setImageDrawable(ContextCompat.getDrawable(MapsActivity.this, R.drawable.indiaflag));
//                        break;
//
//                    case "nepal":
//                        countryFlagImage.setImageDrawable(ContextCompat.getDrawable(MapsActivity.this, R.drawable.nepal));
//                        break;
//
//                    case "Bangladesh":
//                        countryFlagImage.setImageDrawable(ContextCompat.getDrawable(MapsActivity.this, R.drawable.bangladeshflag));
//                        break;
//
//                    default:
//                        break;
//                }
//                countryFlagImage.setLayoutParams(new android.view.ViewGroup.LayoutParams(150, 100));
//                // add the image view to the parent layout
//                parent.addView(countryFlagImage);
//                return parent;
//            }
//            @Override
//            public View getInfoContents(Marker marker) {
//                return null;
//            }
//        });
//    }



}
