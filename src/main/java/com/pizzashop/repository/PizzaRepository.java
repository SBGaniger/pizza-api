package com.pizzashop.repository;

import com.pizzashop.model.Pizza;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends ReactiveMongoRepository<Pizza, String> {}
