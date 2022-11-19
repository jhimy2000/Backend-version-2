package com.merkadeam.market.domain.repository;

import com.merkadeam.market.domain.Purchase;

import java.util.List;
import java.util.Optional;
public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
