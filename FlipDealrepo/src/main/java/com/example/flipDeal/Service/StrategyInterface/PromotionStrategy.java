package com.example.flipDeal.Service.StrategyInterface;

import com.example.flipDeal.dtos.Discount;
import com.example.flipDeal.dtos.Product;

public interface PromotionStrategy {
    public Discount calculateDiscount(Product product);

}
