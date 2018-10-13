package com.mission.chaze.chaze.di.module;

import com.mission.chaze.chaze.di.ApplicationScope;
import com.mission.chaze.chaze.di.ChazeAPIQual;
import com.mission.chaze.chaze.di.EcommerceAPIQual;
import com.mission.chaze.chaze.di.FoodOrderingAPIQual;
import com.mission.chaze.chaze.di.LoginAPIQual;
import com.mission.chaze.chaze.di.SearchEngineAPIQual;
import com.mission.chaze.chaze.repository.network.ChazeAPIService;
import com.mission.chaze.chaze.repository.network.CommonAPIManager;
import com.mission.chaze.chaze.repository.network.ECommerceAPIService;
import com.mission.chaze.chaze.repository.network.FoodOrderingAPIService;
import com.mission.chaze.chaze.repository.network.ICommonAPIManager;
import com.mission.chaze.chaze.repository.network.LoginAPIService;
import com.mission.chaze.chaze.repository.network.SearchEngineAPIService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @ApplicationScope
    ChazeAPIService getChazeService(@ChazeAPIQual Retrofit retroFit) {
        return retroFit.create(ChazeAPIService.class);
    }


    @Provides
    @ApplicationScope
    ECommerceAPIService getEcommerceService(@EcommerceAPIQual Retrofit retroFit) {
        return retroFit.create(ECommerceAPIService.class);
    }

    @Provides
    @ApplicationScope
    FoodOrderingAPIService getFoodOrderingService(@FoodOrderingAPIQual Retrofit retroFit) {
        return retroFit.create(FoodOrderingAPIService.class);
    }

    @Provides
    @ApplicationScope
    SearchEngineAPIService getSearchEngineService(@SearchEngineAPIQual Retrofit retroFit) {
        return retroFit.create(SearchEngineAPIService.class);
    }

    @Provides
    @ApplicationScope
    LoginAPIService getLoginService(@LoginAPIQual Retrofit retroFit) {
        return retroFit.create(LoginAPIService.class);
    }

    @Provides
    @ApplicationScope
    @ChazeAPIQual
    Retrofit getRetrofitChaze(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


    @Provides
    @ApplicationScope
    @EcommerceAPIQual
    Retrofit getRetrofitEcommerce(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


    @Provides
    @ApplicationScope
    @FoodOrderingAPIQual
    Retrofit getRetrofitFood(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    @SearchEngineAPIQual
    Retrofit getRetrofitSearchEngine(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    @LoginAPIQual
    Retrofit getRetrofitLogin(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://google.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


    @Provides
    @ApplicationScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Provides
    @ApplicationScope
    HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    @ApplicationScope
    ICommonAPIManager getCommonAPIManager(CommonAPIManager commonAPIManager) {
        return commonAPIManager;
    }


}
