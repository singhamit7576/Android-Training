package com.example.mythread.ui.JSON;
import android.os.Bundle;
import android.widget.TextView;
import com.example.mythread.R;
import com.example.mythread.ui.BaseAcitivity.BaseActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
/**
 * create Activity Which extends BaseActivity which
 * have some methods.
 */

public class JsonAcitivty extends BaseActivity {
    private TextView tv_json;
    private String data ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_acitivty);
        this.setReference();
        this.onListener();
    }

    @Override
    protected void setReference() {
        tv_json = (TextView)   findViewById(R.id.tv_json);
    }

    public String loadAssets() {
        String json = null;
        try {

            InputStream inputStream = getAssets().open("offielist.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    protected void onListener() {
        try{
            JSONObject jsonObject               =          new JSONObject(loadAssets());
            JSONObject object                   =          jsonObject.getJSONObject("data");
            JSONArray beaconInfoJsonArray       =          object.getJSONArray("beaconInfo");

            for(int i = 0 ; i < beaconInfoJsonArray.length() ;  i++){
                JSONObject beaconInfoObject       =      (JSONObject) beaconInfoJsonArray.get(i);
                addBeaconInfo(beaconInfoObject);

                JSONArray advertisementsJasonArray        =       beaconInfoObject.getJSONArray("advertisements");
                advertisements(advertisementsJasonArray);
                data += "................................................>"+"\n";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        tv_json.setText(""+data);
    }

    private void addBeaconInfo(JSONObject beaconInfoObject) throws JSONException {

        data +=  beaconInfoObject.getString("beaconID")+"\n";
        data +=  beaconInfoObject.getString("beaconName")+"\n";
        data +=  beaconInfoObject.getString("beaconUUID")+"\n";
        data +=  beaconInfoObject.getString("beaconVendor")+"\n";
        data +=  beaconInfoObject.getInt("major")+"\n";
        data +=  beaconInfoObject.getInt("minor")+"\n";
        data +=  beaconInfoObject.getBoolean("status")+"\n";
        data +=  beaconInfoObject.getInt("latitude")+"\n";
        data +=  beaconInfoObject.getDouble("longitude")+"\n";

    }

    private void advertisements(JSONArray advertisementsJasonArray) throws JSONException {

        for(int j  = 0;     j < advertisementsJasonArray.length() ;    j++){
            JSONObject advertisementsObjects =  (JSONObject) advertisementsJasonArray.get(j);
            this.advertismentData(advertisementsObjects);
            this.image(advertisementsObjects);
            this.schedule(advertisementsObjects);
        }
    }

    private void advertismentData(JSONObject advertisementsObjects) throws JSONException {

        data += advertisementsObjects.getInt("adID")+"\n";
        data += advertisementsObjects.getString("adName")+"\n";
        data += advertisementsObjects.getString("enabled")+"\n";
        data += advertisementsObjects.getString("shopName")+"\n";
        data += advertisementsObjects.getString("description")+"\n";
        data += advertisementsObjects.getString("validUpTo")+"\n";

    }

    private void image(JSONObject advertisementsObjects) throws JSONException {
        JSONArray image = advertisementsObjects.getJSONArray("images");

        for(int k = 0 ; k < image.length() ; k++){
            JSONObject imageJsonObject =  (JSONObject) image.get(k);
            data +=  imageJsonObject.getString("imageID")+"\n";
            data +=  imageJsonObject.getString("imageName")+"\n";
            data +=  imageJsonObject.getString("imageURL")+"\n";
            data +=  imageJsonObject.getString("description")+"\n";
        }
    }

    private void schedule(JSONObject advertisementsObjects) throws JSONException {
        JSONArray Schedules = advertisementsObjects.getJSONArray("adSchedules");

        for(int l = 0 ; l < Schedules.length() ; l++){
            JSONObject jasonObjectSchedules =  (JSONObject) Schedules.get(l);
            data +=  jasonObjectSchedules.getInt("adScheduleId")+"\n";
            data +=  jasonObjectSchedules.getInt("adId")+"\n";
            data +=  jasonObjectSchedules.getString("startDate")+"\n";
            data +=  jasonObjectSchedules.getString("endDate")+"\n";
        }
    }
}