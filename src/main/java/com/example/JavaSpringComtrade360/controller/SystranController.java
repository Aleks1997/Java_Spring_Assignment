package com.example.JavaSpringComtrade360.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class SystranController {

    String apiKey = "";


    //localhost:8080/translate?targetLang=ko
    @PostMapping("/translate")
    public ResponseEntity<String> translate(@RequestParam("targetLang") String targetLang) throws IOException {
        String url = "https://api-translate.systran.net/translation/text/translate?key=" + apiKey + "&input=Hello_world&source=en";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("target", targetLang);
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(url,entity, String.class);
        return response;
    }
}
