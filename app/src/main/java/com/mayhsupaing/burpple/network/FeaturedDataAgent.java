package com.mayhsupaing.burpple.network;

/**
 * Created by Lenovo on 1/12/2018.
 */

public interface FeaturedDataAgent {

    /**
     * load feature from API.
     */
    void loadFeatured();

    /**
     * Login user;
     * @param phoneNo
     * @param password
     */
    void loginUser(String phoneNo,String password);

    void registerUser(String name,String password,String phoneNo);
}
