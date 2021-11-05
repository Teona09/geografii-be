package org.geografii.controller;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.dto.QuestionModelDTO;
import org.geografii.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
        save();
    }

    @PostMapping()
    public ResponseEntity<Object> save(){
        QuestionModelDTO ans= new QuestionModelDTO(null,"hgfds","hint",10, new HashSet<>());
        this.questionService.saveQuestion(ans);
        return ResponseEntity.ok().build();
    }
}
