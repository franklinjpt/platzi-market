package dev.franklinjpt.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long productId;
    private String name;
    private long categoryId;
    private double price;
    private int stock;
    private boolean active;
    private Category category;
}
