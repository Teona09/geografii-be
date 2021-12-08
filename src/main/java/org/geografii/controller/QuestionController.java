package org.geografii.controller;

import org.geografii.dto.QuestionModelDTO;
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
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody QuestionModelDTO question){
        this.questionService.saveQuestion(question);
        return ResponseEntity.ok().build();
    }
}
