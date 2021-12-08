package org.geografii.controller;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody AnswerModelDTO ans){
        System.out.println(ans);
        return new ResponseEntity(this.answerService.saveAnswer(ans), HttpStatus.CREATED);
    }
}
