package com.tutorial.microservice.repository;

import com.tutorial.microservice.entity.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial,String> {

}
