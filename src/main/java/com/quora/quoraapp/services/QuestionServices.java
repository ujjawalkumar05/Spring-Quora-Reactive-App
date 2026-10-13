package com.quora.quoraapp.services;

import com.quora.quoraapp.adapter.QuestionAdapter;
import com.quora.quoraapp.dto.QuestionRequestDto;
import com.quora.quoraapp.dto.QuestionResponseDto;
import com.quora.quoraapp.model.Question;
import com.quora.quoraapp.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionServices implements IQuestionServices{


    private final QuestionRepository questionRepository;


    @Override
    public Mono<QuestionResponseDto> createdQuestion(QuestionRequestDto questionRequestDto) {

        Question question = Question.builder()
                .title(questionRequestDto.getTitle())
                .content(questionRequestDto.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return questionRepository.save(question)
                .map(QuestionAdapter::toQuestionResponse)
                .doOnSuccess(response->System.out.println("question created successfully: " + response))
        .doOnError(error->System.out.println("question created error: " + error));
    }
}
