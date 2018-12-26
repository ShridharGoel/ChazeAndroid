package com.chaze.india.models;

import com.chaze.india.models.Ecommerce.CartBusiness;

import java.util.ArrayList;

public class Order {
    private String userName;
    private String userMobile;
    private String userAddress;
    private String orderId;
    private String total;


    //size of cartBusinesses will be equal to size of states, i'th element of states will contain the state of i'th element of cartBusiness
    private ArrayList<CartBusiness> cartBusinesses;
    //State = 0 ->Not confirmed by Chaze
    //State = 1 ->confirmed by Chaze
    //State = 2 ->confirmed by Business
    //State = 3 ->Order picked up
    //State = 4 ->Delivered
    private ArrayList<Integer> states;


    public Order(String userName, String userMobile, String userAddress, String orderId, String totall, ArrayList<CartBusiness> cartBusinesses, ArrayList<Integer> states) {
        this.userName = userName;
        this.userMobile = userMobile;
        this.userAddress = userAddress;
        this.orderId = orderId;
        this.cartBusinesses = cartBusinesses;
        this.states = states;
        this.total = totall;
    }

    public Order() {
        cartBusinesses = new ArrayList<>();
        states = new ArrayList<>();
    }

    public ArrayList<CartBusiness> getCartBusinesses() {
        return cartBusinesses;
    }

    public void addCartBusiness(CartBusiness cartBusiness) {
        cartBusinesses.add(cartBusiness);
        states.add(0);
    }

}
