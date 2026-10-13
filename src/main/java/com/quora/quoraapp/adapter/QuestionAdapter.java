package com.quora.quoraapp.adapter;


import com.quora.quoraapp.dto.QuestionResponseDto;
import com.quora.quoraapp.model.Question;
import lombok.Builder;

@Builder
public class QuestionAdapter {
    public static QuestionResponseDto toQuestionResponse(Question question) {
    return QuestionResponseDto.builder()
            .id(question.getId())
            .title(question.getTitle())
            .content(question.getContent())
            .createdAt(question.getCreatedAt())
            .build();


    }
}

