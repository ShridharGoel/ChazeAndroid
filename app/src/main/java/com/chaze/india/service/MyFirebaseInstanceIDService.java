package com.chaze.india.service;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.chaze.india.AppController;
import com.chaze.india.di.component.DaggerServiceComponent;
import com.chaze.india.di.component.ServiceComponent;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.session.SessionManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.chaze.india.utils.Constants;

import javax.inject.Inject;


public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Inject
    SessionManager sharedPreference;

    @Inject
    ICommonAPIManager iCommonAPIManager;

    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((AppController) getApplication()).getComponent())
                .build();
        component.inject(this);

    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        // Saving reg id to shared preferences
        storeRegIdInPref(refreshedToken);
        storeTokenInDjango(refreshedToken);

        // sending reg id to your server
        // Notify UI that registration has completed, so the progress indicator can be hidden.
        Intent registrationComplete = new Intent(Constants.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", refreshedToken);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }

    private void storeTokenInDjango(String refreshedToken) {
            iCommonAPIManager.getDeliveryAPIService();
    }


    private void storeRegIdInPref(String token) {
        sharedPreference = new SessionManager(getApplicationContext());
        sharedPreference.setFcmToken(token);
    }

    private String getRegIdFromPref() {
        return sharedPreference.getFcmToken();
    }
}

