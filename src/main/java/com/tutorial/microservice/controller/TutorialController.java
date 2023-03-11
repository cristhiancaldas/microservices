package com.tutorial.microservice.controller;

import com.tutorial.microservice.entity.Tutorial;
import com.tutorial.microservice.service.TutorialService;
import io.swagger.v3.oas.annotations.Operation;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tutorial/v1")
public class TutorialController {
    private static Logger logger = LoggerFactory.getLogger(TutorialController.class);
    @Autowired
    TutorialService tutorialService;

    @Operation(summary = "Add Tutorial")
    @PostMapping
    public ResponseEntity<Tutorial> addTutorial(@RequestBody Tutorial tutorial){
        logger.info("Init Controller addTutorial");
        Tutorial addTutorial = tutorialService.addTutorial(tutorial);
        logger.info("Fin Controller addTutorial");

        return ResponseEntity.ok(addTutorial);
    }

    @Operation(summary = "Get all Tutorial")
    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorial(){
        logger.info("Init Controller getAllTutorial");
         List<Tutorial> lstTutorial=  tutorialService.getAllTutorial();
         return    ResponseEntity.ok(lstTutorial);
    }

    @Operation(summary = "Get Tutorial By ID")
    @GetMapping("/{idTutorial}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable String idTutorial){
        logger.info("Init Controller getTutorialById");
        Optional<Tutorial> tutorial=  tutorialService.getTutorialById(idTutorial);
        return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
    }


    @Operation(summary = "Delete Tutorial By ID")
    @DeleteMapping("/{idTutorial}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable String idTutorial){
        logger.info("Init Controller deleteTutorial");
        tutorialService.deleteTutorial(idTutorial);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
