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


    @Inject
    public CommonAPIManager(ChazeAPIService mChazeAPIService,
                            FoodOrderingAPIService mFoodOrderingAPIService,
                            SearchEngineAPIService mSearchEngineAPIService,
                            ECommerceAPIService mECommerceAPIService) {
        this.mChazeAPIService = mChazeAPIService;
        this.mFoodOrderingAPIService = mFoodOrderingAPIService;
        this.mSearchEngineAPIService = mSearchEngineAPIService;
        this.mECommerceAPIService = mECommerceAPIService;
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
}
