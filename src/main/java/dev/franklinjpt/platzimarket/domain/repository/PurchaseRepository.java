package dev.franklinjpt.platzimarket.domain.repository;

import dev.franklinjpt.platzimarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
     List<Purchase> getAll();
     Optional<List<Purchase>> getAllByClient(String clientId);
     Purchase save(Purchase purchase);
}
