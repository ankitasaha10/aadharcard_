package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AadharCard;

@Repository
public interface AadharCardRepository extends MongoRepository<AadharCard, String> {

}
