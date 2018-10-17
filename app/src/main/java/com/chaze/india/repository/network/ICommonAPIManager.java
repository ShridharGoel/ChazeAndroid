package com.chaze.india.repository.network;

public interface ICommonAPIManager {

    ChazeAPIService getChazeAPIService();

    FoodOrderingAPIService getFoodOrderingAPIService();

    SearchEngineAPIService getSearchEngineAPIService();

    ECommerceAPIService getECommerceAPIService();

}
