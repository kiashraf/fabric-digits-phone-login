package com.zeyndoc.zeyndocfabriclogin;

import android.app.Application;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import io.fabric.sdk.android.Fabric;

/**
 * Created by user on 01-06-2016.
 */
public class Authenticate extends Application {


    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "qfBEiAYB7BeZsPEMbuDNW7x1w";
    private static final String TWITTER_SECRET = "0NNccuZipqWSiRQvgTW1SOx6qTYOwr2fkqPYCSN9QGfrWZ33KC";


    private AuthCallback authCallback;

    @Override
    public void onCreate() {
        super.onCreate();


        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());

        authCallback = new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {

                Digits.authenticate(authCallback, "+919534527585");


            }

            @Override
            public void failure(DigitsException error) {

            }
        };
    }

    public AuthCallback getAuthCallback() {
        return authCallback;
    }
}
