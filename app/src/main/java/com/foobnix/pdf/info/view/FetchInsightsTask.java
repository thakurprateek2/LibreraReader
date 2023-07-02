package com.foobnix.pdf.info.view;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class FetchInsightsTask extends AsyncTask<String, Void, String> {

    private static final String TAG = FetchInsightsTask.class.getSimpleName();
    private OnGetRequestListener listener;

    public interface OnGetRequestListener {
        void onGetRequestCompleted(String response);
    }

    public void setOnGetRequestListener(OnGetRequestListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        String selectedText = params[0];

        try {
            String encodedText = URLEncoder.encode(selectedText, "UTF-8");
            String urlString = "https://baconipsum.com/api/?paras=3&format=text&type=meat-and-filler&selectedText=" + encodedText;
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            connection.disconnect();

            return response.toString();

        } catch (IOException e) {
            Log.e(TAG, "Error performing GET request: " + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String response) {
        if (listener != null) {
            listener.onGetRequestCompleted(response);
        }
    }
}
