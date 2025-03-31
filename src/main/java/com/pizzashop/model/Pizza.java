package com.pizzashop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "pizzas")
public class Pizza {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> toppings;
    private List<String> sizeOptions;
    private Double price;
}
