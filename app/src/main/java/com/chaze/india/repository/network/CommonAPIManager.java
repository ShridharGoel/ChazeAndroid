package com.chaze.india.repository.network;

import javax.inject.Inject;

public class CommonAPIManager implements ICommonAPIManager {


    private
    ChazeAPIService mChazeAPIService;

    private
    FoodOrderingAPIService mFoodOrderingAPIService;

    private
    ECommerceAPIService mECommerceAPIService;



    @Inject
    public CommonAPIManager(ChazeAPIService mChazeAPIService,
                            FoodOrderingAPIService mFoodOrderingAPIService,
                            ECommerceAPIService mECommerceAPIService) {
        this.mChazeAPIService = mChazeAPIService;
        this.mFoodOrderingAPIService = mFoodOrderingAPIService;
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
    public ECommerceAPIService getECommerceAPIService() {
        return mECommerceAPIService;
    }


}
