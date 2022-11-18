package dev.franklinjpt.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private long categoryId;
    private String category;
    private boolean active;
}
