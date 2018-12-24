package com.chaze.india.repository.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.chaze.india.models.Ecommerce.CartBusiness;
import com.chaze.india.models.Ecommerce.CartEcommerce;
import com.chaze.india.models.Ecommerce.CartResponse;
import com.google.gson.Gson;

import java.util.Date;

import javax.inject.Inject;

import timber.log.Timber;

public class SessionManager implements ISessionManager {


    private static String TAG = SessionManager.class.getSimpleName();

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;
    private Context _context;

    int PRIVATE_MODE = 0;

    // Shared preferences file name
    public static final String PREF_NAME = "chazeSession";

    // Application keys
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";

    private static final String KEY_AUTH_PROVIDER = "authProvider";

    private static final String KEY_SELECTED_SERVICE = "selectedService";

    private static final String KEY_CART_ECOMMERCE = "currentCartStateEcommerce";

    private static final String USER_MOBILE = "phone_no";

    private static final String USER_NAME = "user_name";

    private static final String USER_EMAIL = "user_email";

    private static final String USER_ADDRESS = "user_address";

    private static final String USER_GENDER = "user_gender";

    private static final String KEY_CART_FOOD = "currentCartStateFood";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String FB_USER_SAVED_MOBILE = "fbUserSavedMobile";

    private static final String FB_USER_SAVED_EMAIL = "fbUserSavedEmail";

    private static final String GMAIL_USER_SAVED_MOBILE = "fbUserSavedMobile";

    private static final String GMAIL_USER_SAVED_EMAIL = "fbUserSavedEmail";

    private static final String PREVIOUS_ORDER_ID = "previousOrderId";

    private static final String IS_PREVIOUS_ORDER_RATED = "isPreviousOrderRated";

    private static final String PREVIOUS_ORDER_CART_FOOD = "previousOrderCart";


    private static final String PREVIOUS_ORDER_CART_ECOMMERCE = "previousOrderCart";

    private static final String PREVIOUS_ORDER_TIME = "previousOrderTime";

    private static final String ADDRESS = "address";

    private static final String FCM_TOKEN = "fcm_token";

    private static final String TOKEN = "token";


    @Inject
    public SessionManager(Context c) {
        this._context = c;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    @Override
    public void setUserEmail(String email) {
        editor.putString(USER_EMAIL, email);
        editor.commit();
    }

    @Override
    public String getUserEmail() {
        return pref.getString(USER_EMAIL, null);
    }

    @Override
    public void setUserAddress(String address) {
        editor.putString(USER_ADDRESS, address);
        editor.commit();
    }

    @Override
    public String getUserAddress() {
        return pref.getString(USER_ADDRESS, null);
    }

    @Override
    public void setGender(String gender) {
        editor.putString(USER_GENDER, gender);
        editor.commit();
    }

    @Override
    public String getGender() {
        return pref.getString(USER_GENDER, null);
    }

    @Override
    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    @Override
    public void setPhoneNo(String userPhone) {
        editor.putString(USER_MOBILE, userPhone);
        editor.commit();
    }

    @Override
    public String getPhoneNo() {
        return pref.getString(USER_MOBILE, null);
    }

    @Override
    public void setFcmToken(String fcmToken) {
        editor.putString(FCM_TOKEN, fcmToken);
        editor.commit();
    }

    @Override
    public String getFcmToken() {
        return pref.getString(FCM_TOKEN, null);
    }

    @Override
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    @Override
    public void setFbUserSavedMobile(String mobile) {
        editor.putString(FB_USER_SAVED_MOBILE, mobile);
        editor.commit();
    }

    @Override
    public String getFbUserSavedMobile() {
        return pref.getString(FB_USER_SAVED_EMAIL, null);
    }

    @Override
    public void setFbUserSavedEmail(String email) {
        editor.putString(FB_USER_SAVED_EMAIL, email);
        editor.commit();
    }

    @Override
    public String getFbUserSavedEmail() {
        return pref.getString(FB_USER_SAVED_EMAIL, null);
    }

    @Override
    public void setGmailUserSavedMobile(String mobile) {
        editor.putString(GMAIL_USER_SAVED_MOBILE, mobile);
        editor.commit();
    }

    @Override
    public String getGmailUserSavedMobile() {
        return pref.getString(GMAIL_USER_SAVED_MOBILE, null);
    }

    @Override
    public void setGmailUserSavedEmail(String email) {
        editor.putString(GMAIL_USER_SAVED_EMAIL, email);
        editor.commit();
    }

    @Override
    public String getGmailUserSavedEmail() {
        return pref.getString(GMAIL_USER_SAVED_EMAIL, null);
    }

    @Override
    public void setAddress(String address) {
        editor.putString(ADDRESS, address);
        editor.commit();
    }

    @Override
    public String getAddress() {
        return pref.getString(ADDRESS, null);
    }

    @Override
    public void setLogin(boolean isLoggedIn, String authProvider) {
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.putString(KEY_AUTH_PROVIDER, authProvider);

        editor.commit();

        Timber.d(TAG, "User login session modified!");
    }

    @Override
    public boolean isLoggedIn() {
        return pref.getBoolean(KEY_IS_LOGGEDIN, false);
    }

    @Override
    public String getKeyAuthProvider() {
        return pref.getString(KEY_AUTH_PROVIDER, null);
    }

    @Override
    public void setSelectedService(String service) {
        editor.putString(ADDRESS, service);
        editor.commit();
    }

    @Override
    public String getSelectedService() {
        return pref.getString(KEY_SELECTED_SERVICE, null);
    }

    @Override
    public void setCurrentCartStateFood(CartBusiness cartFood) {
        Gson gson = new Gson();
        String json = gson.toJson(cartFood);
        editor.putString(KEY_CART_FOOD, json);

        editor.commit();

        Log.d(TAG, "CartFood state updated");
    }

    @Override
    public CartBusiness getCurrentCartStateFood() {
        Gson gson = new Gson();
        String json = pref.getString(KEY_CART_FOOD, null);
        CartBusiness cart = gson.fromJson(json, CartBusiness.class);

        return cart;
    }

    @Override
    public void setCurrentCartStateEcommerce(CartResponse cartEcommerce) {
        Gson gson = new Gson();
        String json = gson.toJson(cartEcommerce);
        editor.putString(KEY_CART_ECOMMERCE, json);

        editor.commit();

        Timber.d(TAG, "CartEcommerce state updated");
    }

    @Override
    public CartResponse getCurrentCartStateEcommerce() {
        Gson gson = new Gson();
        String json = pref.getString(KEY_CART_ECOMMERCE, null);
        if (json == null) return null;

        CartResponse cart = gson.fromJson(json, CartResponse.class);
        return cart;
    }

    @Override
    public void setPreviousOrderCartEcommerce(CartEcommerce cartEcommerce) {

        Date date = new Date(System.currentTimeMillis());
        long previousOrderTime = date.getTime();

        Gson gson = new Gson();
        String json = gson.toJson(cartEcommerce);
        editor.putString(PREVIOUS_ORDER_CART_ECOMMERCE, json);
        editor.putLong(PREVIOUS_ORDER_TIME, previousOrderTime);

        editor.commit();

        Timber.d(TAG, "Previous order cart saved");

    }

    @Override
    public void setPreviousOrderCartFood(CartBusiness cartFood) {

        Date date = new Date(System.currentTimeMillis());
        long previousOrderTime = date.getTime();

        Gson gson = new Gson();
        String json = gson.toJson(cartFood);
        editor.putString(PREVIOUS_ORDER_CART_FOOD, json);
        editor.putLong(PREVIOUS_ORDER_TIME, previousOrderTime);

        editor.commit();

        Timber.d(TAG, "Previous order cart saved");
    }

    @Override
    public CartEcommerce getPreviousOrderCartEcommerce() {

        Gson gson = new Gson();
        String json = pref.getString(PREVIOUS_ORDER_CART_ECOMMERCE, null);
        CartEcommerce cart = gson.fromJson(json, CartEcommerce.class);

        return cart;
    }

    @Override
    public CartBusiness getPreviousOrderCartFood() {

        Gson gson = new Gson();
        String json = pref.getString(PREVIOUS_ORDER_CART_FOOD, null);
        CartBusiness cart = gson.fromJson(json, CartBusiness.class);

        return cart;
    }


    @Override
    public Date getPreviousOrderTime() {
        Date date = new Date(pref.getLong(PREVIOUS_ORDER_TIME, 0));

        return date;
    }

    @Override
    public void setUserName(String userName) {
        editor.putString(USER_NAME, userName);
        editor.commit();
    }

    @Override
    public String getUserName() {
        //this function returns null by default
        return pref.getString(USER_NAME, null);
    }

    @Override
    public void setToken(String token) {
        editor.putString(TOKEN, token);
        editor.commit();
    }

    @Override
    public String getToken() {
        return pref.getString(TOKEN, "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTAxLCJ2YWwiOjIsImlhdCI6MTU0NDY0MDM1NX0.I9vJ5DURfUofoYh4MEj5tlyL7IuceKlWZRgmpzSW1Go");
    }

}
