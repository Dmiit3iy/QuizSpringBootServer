package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

public class ResultServiceImpl implements ResultService {
    private RestTemplate restTemplate = new RestTemplate();
    @Value("${quiz.link}")
    public String url;

    @Override
    public Result get(String amount, String category, String difficulty) {
        return this.restTemplate.exchange(this.url + "?amount={amount}" + "&category={category}" + "&difficulty={difficulty}", HttpMethod.GET, null,
                new ParameterizedTypeReference<Result>() {
                }, amount, category, difficulty).getBody();
    }
}
