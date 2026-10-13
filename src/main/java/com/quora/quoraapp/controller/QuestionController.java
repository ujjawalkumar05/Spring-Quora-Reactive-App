package com.quora.quoraapp.controller;


import com.quora.quoraapp.dto.QuestionRequestDto;
import com.quora.quoraapp.dto.QuestionResponseDto;
import com.quora.quoraapp.repository.QuestionRepository;
import com.quora.quoraapp.services.IQuestionServices;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final IQuestionServices questionService;

    @PostMapping()
    public Mono<QuestionResponseDto> createdQuestion(@RequestBody QuestionRequestDto questionRequestDto) {
      return questionService.createdQuestion(questionRequestDto)
              .doOnSuccess(response->System.out.println("question created successfully: " + response))
              .doOnError(error->System.out.println("question created error: " + error));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDto> getQuestion(@PathVariable String id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @GetMapping()
    public Flux<QuestionResponseDto> getQuestions() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @DeleteMapping("/{id}")
    public Mono<QuestionResponseDto> deleteQuestion(@PathVariable String id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(@RequestParam String query,
                                                     @RequestParam(defaultValue="0")int page, @RequestParam(defaultValue="10")int size) {

        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @GetMapping("/tag/{tage}")
    public Flux<QuestionResponseDto> getQuestionsByTag(@PathVariable String tage,
                                                       @RequestParam(defaultValue="0")int page, @RequestParam(defaultValue="10") int size) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }



}
