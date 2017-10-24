package com.example.justd.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity  {

    private SignInButton SignIn;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE = 9001;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // SignIn = (SignInButton) findViewById(R.id.bn_login);
        // SignIn.setOnClickListener(this);
        // GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        // googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();


        // if (googleServicesAvail()) {
        //     Toast.makeText(this, "You have Google Play Services YAY", Toast.LENGTH_LONG).show();
        // }

         }

    public void goMap(View view) {
        Intent goToMap = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(goToMap);
        Log.d(TAG, "goMap: was clicked");
    }

    public void goMenu(View view) {
        Intent goToMenu = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(goToMenu);
        Log.d(TAG, "goMenu: was clicked");
    }
}
    /*public boolean googleServicesAvail() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int isAvailable = api.isGooglePlayServicesAvailable(this);
        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (api.isUserResolvableError(isAvailable)) {
            Dialog msg = api.getErrorDialog(this, isAvailable, 0);
            msg.show();
        } else {
            Toast.makeText(this, "Can't connect to play services :*(", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    /**
     * Called when the user taps the login button



    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bn_login:
                //SignIn();
                break;
        }

    }
}

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void SignIn()
    {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);

    }

    public void startActivityForResult(Intent intent, int reqCode) {
    }

    private void handleResult(GoogleSignInResult result)
    {
        if(result.isSuccess())

        {
            GoogleSignInAccount account = result.getSignInAccount();

        }
    }
    private void updateUI(boolean isLogin)
    {

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQ_CODE)
        {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }
}
        */
//
