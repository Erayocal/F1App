package com.example.mobilprogramlama;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int SPLASH_DURATION = 3000;
    private boolean isConnected = false;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                checkInternetAndProceed();
            }
        };

        // İlk kontrol
        handler.postDelayed(runnable, SPLASH_DURATION);
    }

    private void checkInternetAndProceed() {
        if (checkInternetConnection()) {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "İnternet bağlantınızı kontrol ediniz!", Toast.LENGTH_LONG).show();
            // 3 saniye sonra tekrar kontrol et
            handler.postDelayed(runnable, SPLASH_DURATION);
        }
    }

    private boolean checkInternetConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
} 