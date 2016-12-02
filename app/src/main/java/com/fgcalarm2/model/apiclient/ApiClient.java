package com.fgcalarm2.model.apiclient;

import android.os.AsyncTask;
import android.util.Log;

import com.fgcalarm2.model.apiclient.response.CirculacioResponse;

import java.util.Date;
import java.util.List;

/**
 * Created by Biel on 14/11/2016.
 */

public class ApiClient {

    private final String tag = "ApiClient";

    public List<CirculacioResponse> getCirculacions(Date start, Date end){
        return null; //Implement
    }
    private class HttpRequestTask extends AsyncTask<Void, Void, List<CirculacioResponse>> {
        @Override
        protected List<CirculacioResponse> doInBackground(Void... params) {
            try {

            } catch (Exception e) {
                Log.e(tag, e.getMessage(), e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<CirculacioResponse> result) {
            //Async operation finished
        }

    }
}
