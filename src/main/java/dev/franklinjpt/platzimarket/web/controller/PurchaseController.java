package dev.franklinjpt.platzimarket.web.controller;

import dev.franklinjpt.platzimarket.domain.Purchase;
import dev.franklinjpt.platzimarket.domain.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll() {
        return ResponseEntity.ok(purchaseService.getAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Purchase>> getAllByClient(@PathVariable("id") String clientId) {
        return ResponseEntity.of(purchaseService.getAllByClient(clientId).filter(purchases-> !purchases.isEmpty()));
    }

    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseService.save(purchase));
    }
}
