package com.dmiit3iy.quizespringboot.service;

import com.dmiit3iy.quizespringboot.model.Result;

public interface ResultService {
    Result get (String amount, String category, String difficulty);
}
