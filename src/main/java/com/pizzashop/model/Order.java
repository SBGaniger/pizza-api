package com.pizzashop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;
import java.util.List;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private List<Pizza> pizzas;
    private String status; // "Preparing", "Delivered"
    private Instant timestamp = Instant.now();
}
