package com.pizzashop.service;

import org.springframework.stereotype.Service;

import com.pizzashop.model.Pizza;
import com.pizzashop.repository.PizzaRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Mono<Pizza> addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Flux<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Mono<Pizza> getPizzaById(String id) {
        return pizzaRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Pizza not found!")));
    }

    public Mono<Pizza> updatePizza(String id, Pizza updatedPizza) {
        return pizzaRepository.findById(id)
                .flatMap(existingPizza -> {
                    existingPizza.setName(updatedPizza.getName());
                    existingPizza.setDescription(updatedPizza.getDescription());
                    existingPizza.setToppings(updatedPizza.getToppings());
                    existingPizza.setSize(updatedPizza.getSize());
                    existingPizza.setPrice(updatedPizza.getPrice());
                    return pizzaRepository.save(existingPizza);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Pizza not found!")));
    }

    public Mono<Void> deletePizza(String id) {
        return pizzaRepository.deleteById(id);
    }
}
