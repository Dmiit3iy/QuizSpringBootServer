package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.ResponseResultTrivia;

public interface ResponseResultTriviaService {
    ResponseResultTrivia get(String amount, String category, String difficulty);

    ResponseResultTrivia add(ResponseResultTrivia responseResult);
}
