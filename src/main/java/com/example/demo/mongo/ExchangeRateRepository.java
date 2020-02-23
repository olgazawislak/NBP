package com.example.demo.mongo;

import com.example.demo.ExchangeRate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public
interface ExchangeRateRepository extends MongoRepository<ExchangeRate, UUID> {


}
