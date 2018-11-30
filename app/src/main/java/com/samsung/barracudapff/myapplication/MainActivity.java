package com.samsung.barracudapff.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //Color color = Color.valueOf();
                    button.setBackgroundColor(Color.rgb(
                            new Random().nextInt(100),
                            new Random().nextInt(100),
                            new Random().nextInt(100)));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*URL yahoo = null;
                try {
                    yahoo = new URL("http://www.yahoo.com/");
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    yahoo.openStream()));

                    String inputLine;

                    while ((inputLine = in.readLine()) != null)
                        System.out.println(inputLine);

                    in.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
                WebView webView = findViewById(R.id.web);
                // включаем поддержку JavaScript
                webView.getSettings().setJavaScriptEnabled(true);
                // указываем страницу загрузки
                webView.loadUrl("https://stackoverflow.com/questions/2075836/read-contents-of-a-url-in-android/");
                new GetDataTask().execute((TextView) findViewById(R.id.text));
            }
        });
    }
}
