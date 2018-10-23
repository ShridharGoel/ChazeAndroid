package com.chaze.india.di.module;

import com.chaze.india.di.ApplicationScope;
import com.chaze.india.di.ChazeAPIQual;
import com.chaze.india.di.DeliveryAPIQual;
import com.chaze.india.di.EcommerceAPIQual;
import com.chaze.india.di.FoodOrderingAPIQual;
import com.chaze.india.di.SearchEngineAPIQual;
import com.chaze.india.repository.network.DeliveryAPIService;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.di.ApplicationScope;
import com.chaze.india.di.ChazeAPIQual;
import com.chaze.india.di.EcommerceAPIQual;
import com.chaze.india.di.FoodOrderingAPIQual;
import com.chaze.india.di.SearchEngineAPIQual;
import com.chaze.india.repository.network.ChazeAPIService;
import com.chaze.india.repository.network.CommonAPIManager;
import com.chaze.india.repository.network.ECommerceAPIService;
import com.chaze.india.repository.network.FoodOrderingAPIService;
import com.chaze.india.repository.network.ICommonAPIManager;
import com.chaze.india.repository.network.SearchEngineAPIService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
    @ChazeAPIQual
    Retrofit getRetrofitChaze(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://com.chaze.india-api.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }


    @Provides
    @ApplicationScope
    @EcommerceAPIQual
    Retrofit getRetrofitEcommerce(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://com.chaze.india-api.herokuapp.com/ecommerce/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @ApplicationScope
    @DeliveryAPIQual
    Retrofit getRetrofitDelivery(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("http://192.168.43.145:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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

    @Provides
    @ApplicationScope
    DeliveryAPIService getDeliveryAPIService(@DeliveryAPIQual Retrofit retrofit){
        return retrofit.create(DeliveryAPIService.class);
    }
}
