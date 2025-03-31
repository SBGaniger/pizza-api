package com.pizzashop.controller;

import com.pizzashop.model.Pizza;
import com.pizzashop.service.PizzaService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public Mono<Pizza> addPizza(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    @GetMapping
    public Flux<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Mono<Pizza> getPizzaById(@PathVariable String id) {
        return pizzaService.getPizzaById(id);
    }

    @PutMapping("/{id}")
    public Mono<Pizza> updatePizza(@PathVariable String id, @RequestBody Pizza pizza) {
        return pizzaService.updatePizza(id, pizza);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deletePizza(@PathVariable String id) {
        return pizzaService.deletePizza(id);
    }
}
