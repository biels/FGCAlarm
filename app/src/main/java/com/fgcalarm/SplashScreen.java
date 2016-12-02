package com.fgcalarm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fgcalarm.model.persistence.RepositoryManager;
import com.fgcalarm.model.provisioning.ProvisioningManager;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new StartMainActivityTask().execute();

    }
    class StartMainActivityTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            RepositoryManager.attatchImplementation(RepositoryManager.ImplementationType.IN_MEMORY);
            ProvisioningManager.provisionModel(ProvisioningManager.ProvisioningStrategy.HARDCODED);
            try {
                Thread.sleep(500); //Can be removed if previous work already takes significant time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
