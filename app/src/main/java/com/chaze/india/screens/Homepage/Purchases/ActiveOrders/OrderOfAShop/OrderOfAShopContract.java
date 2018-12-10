package com.chaze.india.screens.Homepage.Purchases.ActiveOrders.OrderOfAShop;

import android.os.Bundle;

import com.chaze.india.screens.base.MvpContract;

import io.reactivex.subjects.PublishSubject;

public class OrderOfAShopContract {
    public interface View extends MvpContract.View{

    }
    public interface Presenter<V extends View> extends MvpContract.Presenter<V>{

    }
}
