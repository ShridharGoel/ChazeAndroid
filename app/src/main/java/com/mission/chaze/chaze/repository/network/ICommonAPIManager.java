package com.mission.chaze.chaze.repository.network;

public interface ICommonAPIManager {

    ChazeAPIService getChazeAPIService();

    FoodOrderingAPIService getFoodOrderingAPIService();

    SearchEngineAPIService getSearchEngineAPIService();

    ECommerceAPIService getECommerceAPIService();

}
