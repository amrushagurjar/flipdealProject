package com.example.flipDeal.Service.StrategyInterface;

import com.example.flipDeal.dtos.Discount;
import com.example.flipDeal.dtos.Product;
import org.springframework.stereotype.Component;

@Component("PROMOTIONSETB")
public class PromotionSetB implements PromotionStrategy {

    @Override
    public Discount calculateDiscount(Product product) {

        Discount discountDetails = new Discount();
        double discount = 0.0;
        String Promotion_Tag = "";
        if (product.getInventory() > 20) {
            discount = product.getPrice() * 0.12;
            Promotion_Tag = "GET 12% OFF";
        }
        if ("NEW".equalsIgnoreCase(product.getArrival())) {
            if (product.getPrice() * 0.07 > discount) {
                Promotion_Tag = "GET 7% OFF";
                discount = product.getPrice() * 0.07;
            }
        }

        discountDetails.setDiscount_tag(Promotion_Tag);
        discountDetails.setAmount(discount);
        return discountDetails;

    }
}
