package com.kanyerest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        button = (Button) findViewById(R.id.getQuote);
        textView = (TextView) findViewById(R.id.quote);

        String url = "https://api.kanye.rest/";

        button.setOnClickListener(l -> {
            String quoteFromResponse = Objects.requireNonNull(getQUoteee(url)).getQuote();

            int height = 200;
            for (int i = 0; i < quoteFromResponse.length(); i++)
                if (i % 26 == 0 && i != 0)
                    height += 100;

            textView.setHeight(height);
            textView.setText(quoteFromResponse);
            System.out.println(quoteFromResponse);
        });
    }

    private Quote getQUoteee(String url) {
        try {
            return new RecieveRequestService().execute(url).get().getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}