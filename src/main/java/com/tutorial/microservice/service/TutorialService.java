package com.tutorial.microservice.service;


import com.tutorial.microservice.entity.Tutorial;
import com.tutorial.microservice.repository.TutorialRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TutorialService {

    private static Logger logger = LoggerFactory.getLogger(TutorialService.class);

    @Autowired
    TutorialRepository tutorialRepository;

    public Tutorial addTutorial(Tutorial tutorial) {
        logger.info("Init Service addTutorial");
        tutorial.setIdTutorial(UUID.randomUUID().toString());
        logger.info("Fin Service addTutorial");

        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> getAllTutorial() {
        logger.info("Init Service getAllTutorial");
        return tutorialRepository.findAll();
    }

    public Optional<Tutorial> getTutorialById(String idTutorial) {
        logger.info("Init Service getTutorialById");
        return tutorialRepository.findById(idTutorial);
    }

    public void deleteTutorial(String idTutorial) {
        logger.info("Init Service deleteTutorial");
        tutorialRepository.deleteById(idTutorial);
    }
}