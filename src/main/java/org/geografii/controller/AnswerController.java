package org.geografii.controller;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.model.AnswerModel;
import org.geografii.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping()
    public ResponseEntity<Object> save(){
        AnswerModelDTO ans= new AnswerModelDTO(Long.parseLong("2"),"hgfds",true);
        this.answerService.saveAnswer(ans);
        return ResponseEntity.ok().build();
    }
}
