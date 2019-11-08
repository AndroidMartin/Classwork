package com.amarted.myapplication.com.amarted.myvolleyparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private final static String URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/units";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create request que class
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET,URL,new JSONArray(),new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response){

                for (int i=0; i < response.length(); i++)
                    try {
                        JSONObject unitObject = response.getJSONObject(i);
                        Log.d("units", unitObject.getString("name"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                Log.d("Response",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error){
                VolleyLog.d("Unknown Error",error.getMessage());
            }
        });
        queue.add(arrayRequest);
    }
}
