package com.zeyndoc.zeyndocfabriclogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

private static final String TWITTER_KEY ="qfBEiAYB7BeZsPEMbuDNW7x1w";
    private static final String TWITTER_SECRET = "0NNccuZipqWSiRQvgTW1SOx6qTYOwr2fkqPYCSN9QGfrWZ33KC";

Authenticate authenticate = new Authenticate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits());
        setContentView(R.layout.activity_main);


        DigitsAuthButton digitsAuthButton = (DigitsAuthButton)findViewById(R.id.auth_button);

        Digits.getSessionManager().clearActiveSession();

        digitsAuthButton.setCallback(((Authenticate)getApplication()).getAuthCallback());
      //  digitsAuthButton.setCallback(authenticate.getAuthCallback());

    }
}
