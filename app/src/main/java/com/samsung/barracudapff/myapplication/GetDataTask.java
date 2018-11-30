package com.samsung.barracudapff.myapplication;

import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.BreakIterator;
import java.util.ArrayList;

public class GetDataTask extends AsyncTask<TextView, Void, Void> {

    private String jsonString;
    private TextView tv;
    String url = "http://api.wolframalpha.com/v2/query?input=%7B%7B1,2.321%7D,%7B3,4%7D%7D*%7B%7Bx%7D,%7By%7D%7D%3D%7B%7B5%7D,%7B6%7D%7D&appid=3X24ыыы3L-365U7PG6EK&&output=JSON";

    @Override
    protected Void doInBackground(TextView... textViews) {
        this.tv = textViews[0];
        try {
            jsonString = getJsonFromServer(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        tv.setText(jsonString);

    }

    public static String getJsonFromServer(String url) throws IOException {

        BufferedReader inputStream = null;

        URL jsonUrl = new URL(url);
        URLConnection dc = jsonUrl.openConnection();

        dc.setConnectTimeout(5000);
        dc.setReadTimeout(5000);

        inputStream = new BufferedReader(new InputStreamReader(
                dc.getInputStream()));

        // read the JSON results into a string
        String jsonResult = inputStream.readLine();
        return jsonResult;
    }

}