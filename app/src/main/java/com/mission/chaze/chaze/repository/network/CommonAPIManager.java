package com.mission.chaze.chaze.repository.network;

import javax.inject.Inject;

public class CommonAPIManager implements ICommonAPIManager {



    private
    ChazeAPIService mChazeAPIService;

    private
    FoodOrderingAPIService mFoodOrderingAPIService;

    private
    SearchEngineAPIService mSearchEngineAPIService;

    private
    ECommerceAPIService mECommerceAPIService;

    private
    LoginAPIService mLoginAPIService;


    @Inject
    public CommonAPIManager(ChazeAPIService mChazeAPIService,
                            FoodOrderingAPIService mFoodOrderingAPIService,
                            SearchEngineAPIService mSearchEngineAPIService,
                            ECommerceAPIService mECommerceAPIService,
                            LoginAPIService mLoginAPIService) {
        this.mChazeAPIService = mChazeAPIService;
        this.mFoodOrderingAPIService = mFoodOrderingAPIService;
        this.mSearchEngineAPIService = mSearchEngineAPIService;
        this.mECommerceAPIService = mECommerceAPIService;
        this.mLoginAPIService = mLoginAPIService;
    }

    @Override
    public ChazeAPIService getChazeAPIService() {
        return mChazeAPIService;
    }

    @Override
    public FoodOrderingAPIService getFoodOrderingAPIService() {
        return mFoodOrderingAPIService;
    }

    @Override
    public SearchEngineAPIService getSearchEngineAPIService() {
        return mSearchEngineAPIService;
    }

    @Override
    public ECommerceAPIService getECommerceAPIService() {
        return mECommerceAPIService;
    }

    @Override
    public LoginAPIService getLoginAPIService() {
        return mLoginAPIService;
    }
}
