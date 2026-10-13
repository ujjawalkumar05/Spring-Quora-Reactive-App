package com.quora.quoraapp.services;

import com.quora.quoraapp.dto.QuestionRequestDto;
import com.quora.quoraapp.dto.QuestionResponseDto;
import reactor.core.publisher.Mono;

public interface IQuestionServices {

    Mono<QuestionResponseDto> createdQuestion(QuestionRequestDto questionRequestDto);

}