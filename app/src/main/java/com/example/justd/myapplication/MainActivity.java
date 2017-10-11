package com.example.justd.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener  {

    private SignInButton SignIn;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignIn = (SignInButton)findViewById(R.id.bn_login);
        SignIn.setOnClickListener(this);

        if(googleServicesAvail()){
            Toast.makeText(this,"You have Google Play Services YAY", Toast.LENGTH_LONG).show();

        }
    }


    public boolean googleServicesAvail(){
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if(isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)){
            Dialog msg =  api.getErrorDialog(this,isAvailable,0);
            msg.show();
        } else {
            Toast.makeText(this, "Can't connect to play services :*(", Toast.LENGTH_LONG).show();
        }
        return false;
    }
    /** Called when the user taps the login button **/
    public void goMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void goMenu(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
//
