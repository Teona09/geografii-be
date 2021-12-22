package org.geografii.controller;

import org.geografii.dto.LevelModelDTO;
import org.geografii.service.LevelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/levels")
public class LevelController {
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id){
        return new ResponseEntity(levelService.getLevelById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getByRegiune(@RequestParam("regiune") String regiune){
        return new ResponseEntity(levelService.getLevelByRegiune(regiune), HttpStatus.OK);
    }

}
