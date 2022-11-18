package dev.franklinjpt.platzimarket.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Purchase {
    private long purchaseId;
    private String clientId;
    private LocalDateTime date;
    private char paymentMethod;
    private String comment;
    private char state;
    private List<PurchaseItem> items;
}
