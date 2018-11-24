package com.bigelin.bigelin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.bigelin.bigelin.AqRequest.AqStringRequest;
import com.bigelin.bigelin.OrtakEkranlar.Pojo.Gelin;
import com.bigelin.bigelin.OrtakEkranlar.Pojo.Gelinlikci;
import com.bigelin.bigelin.Util.MyApplication;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.bigelin.bigelin.Util.StaticFields.BASE_URL;
import static com.bigelin.bigelin.Util.StaticFields.HASH;
import static com.bigelin.bigelin.Util.StaticFields.PROCESS_GELINLIKCI;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String loginResponse = MyApplication.get().getPreferences().getString("loginResponse", null);
        if (loginResponse != null) {
            try {
                JSONObject jsonObject = new JSONObject(loginResponse);
                Gelin gelin = new Gelin(jsonObject);
                aqRequest(gelin.getGelinID(), PROCESS_GELINLIKCI);
            } catch (JSONException e) {
                try {
                    JSONObject jsonObject = new JSONObject(loginResponse);
                    Gelinlikci gelinlikci = new Gelinlikci(jsonObject);
                    aqRequest(gelinlikci.getUserID(), PROCESS_GELINLIKCI);
                } catch (JSONException e1) {
                    e1.printStackTrace();
                    Log.wtf(TAG, "oto login catch : " + e1.getMessage());
                }
            }
        }

    }

    private void aqRequest(int userID, int process) {
        Map<String, String> params = new HashMap<>();
        params.put("userID", userID + "");
        params.put("process", process + "");
        params.put("hash", HASH);

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.wtf(TAG, "onResponse : " + response);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.wtf(TAG, "onErrorResponse : " + error);
            }
        };

        AqStringRequest aqStringRequest = new AqStringRequest(TAG, BASE_URL + "userList.php", params, listener, errorListener);
        MyApplication.get().getRequestQueue().add(aqStringRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
