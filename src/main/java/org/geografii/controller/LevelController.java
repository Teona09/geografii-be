package org.geografii.controller;

import org.geografii.dto.AnswerModelDTO;
import org.geografii.dto.LevelModelDTO;
import org.geografii.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody LevelModelDTO levelModelDTO) {
        levelService.saveLevel(levelModelDTO);
        return ResponseEntity.ok().build();
    }


}
