package com.mission.chaze.chaze.retrofit;

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL = "https://chaze-api.herokuapp.com/ecommerce/shops/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}