package com.tutorial.microservice.controller;

import com.tutorial.microservice.entity.Tutorial;
import com.tutorial.microservice.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutorial/v1")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @PostMapping
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
        Tutorial addTutorial = tutorialService.addTutorial(tutorial);
        return ResponseEntity.ok(addTutorial);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorial(){
         List<Tutorial> lstTutorial=  tutorialService.getAllTutorial();
         return    ResponseEntity.ok(lstTutorial);
    }

    @GetMapping("/{idTutorial}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable String idTutorial){
        Optional<Tutorial> tutorial=  tutorialService.getTutorialById(idTutorial);
        return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
    }


    @DeleteMapping("/{idTutorial}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable String idTutorial){
        tutorialService.deleteTutorial(idTutorial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
