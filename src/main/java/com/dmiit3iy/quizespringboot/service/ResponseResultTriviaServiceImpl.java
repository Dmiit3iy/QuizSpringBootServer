package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.ResponseResultTrivia;
import com.dmiit3iy.quizespringboot.model.Result;
import com.dmiit3iy.quizespringboot.repository.ResponseResultTriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResponseResultTriviaServiceImpl implements ResponseResultTriviaService {
    private ResponseResultTriviaRepository responseResultTriviaRepository;
    private ResultService resultService;

    @Autowired
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired


    public void setResponseResultRepository(ResponseResultTriviaRepository responseResultRepository) {
        this.responseResultTriviaRepository = responseResultRepository;
    }

    private RestTemplate restTemplate = new RestTemplate();
    @Value("${quiz.link}")
    public String url;

    @Override
    public ResponseResultTrivia get(String amount, String category, String difficulty) {
        return this.restTemplate.exchange(this.url + "?amount={amount}" + "&category={category}" + "&difficulty={difficulty}", HttpMethod.GET, null,
                new ParameterizedTypeReference<ResponseResultTrivia>() {
                }, amount, category, difficulty).getBody();
    }

    @Override
    public ResponseResultTrivia add(ResponseResultTrivia responseResult) {
        try {
//            List<Result> resultList = responseResult.getResults();
//            for (Result x : resultList) {
//                resultService.add(x);
//            }
          return responseResultTriviaRepository.save(responseResult);

        } catch (DataIntegrityViolationException e) {
            //подумать над тем какая здесь ошибка может быть? какое условие уникальности
            throw new IllegalArgumentException("такой запрос уже получен");
        }

    }


}
