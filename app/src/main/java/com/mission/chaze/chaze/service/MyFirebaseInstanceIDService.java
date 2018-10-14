package com.foodHaunt.app.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import com.foodHaunt.app.app.AppController;
import com.foodHaunt.app.app.Config.Config;
import com.foodHaunt.app.helper.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shubham on 24/07/17.
 *
 */


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    Context c;

    public MyFirebaseInstanceIDService(Context c) {
        this.c = c;
    }

    public MyFirebaseInstanceIDService() {

    }

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();


    public static final String PUSH_NOTIFICATION_KEY = "https://firebasesaddacampus.000webhostapp.com/get_firebase.php";

    public static final String UPDATE_KEY = "https://firebasesaddacampus.000webhostapp.com/get_update.php";

    SessionManager sm;

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Saving reg id to shared preferences
        storeRegIdInPref(refreshedToken);

        // sending reg id to your server
        sendRegistrationToServer(refreshedToken);

        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(Config.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", refreshedToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    public void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        Log.e(TAG, "sendRegistrationToServer: " + token);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Config.URL_UPDATE_USER_FIREBASE_TOKEN, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, response);
                try {
                    JSONObject responseObj = new JSONObject(response);//creating json object from string request
                    if(responseObj.getBoolean("error")){
                        //Todo
                        //token updated
                    }else{
                        //Todo
                        //some error occurred
                    }


                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                //  Log.e("Sub Category Activity  line no. 204", error.getMessage());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("UID", AppController.getInstance().getDbManager().getUserUid());
                params.put("token",token);
                Log.e(TAG,params.toString());

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    public void getFireBaseKey() {

        String key = "1";
        AppController.getInstance().getSessionManager().setfirebaseKey(key);
    }
    public void getFireBaseId(){

        String key = "1";
        AppController.getInstance().getSessionManager().setfirebaseKey(key);



    }

    public void getUpdateKey(){


        StringRequest stringRequest = new StringRequest(Request.Method.GET, Config.UPDATE_KEY, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseObj = new JSONObject(response);
                    JSONObject resultObj = responseObj.getJSONObject("result");
                    String key = resultObj.getString("key");
                    if(key.equals(1)){
                        resultObj.getString("url");
                    }
                } catch (JSONException e) {

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void storeRegIdInPref(String token) {
        SharedPreferences pref;
        if(c!=null) {
            pref = c.getSharedPreferences(Config.SHARED_PREF, 0);
        }else{
            pref = getApplicationContext().getSharedPreferences(Config.SHARED_PREF, 0);
        }SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.commit();
    }
}

