package com.kanyerest;

import android.os.AsyncTask;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RecieveRequestService extends AsyncTask<String, Void, ResponseEntity<Quote>> {


    @Override
    protected ResponseEntity<Quote> doInBackground(String... strings) {

        final String url = strings[0];

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters()
                .add(new MappingJackson2HttpMessageConverter());

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, Quote.class);
    }
}
