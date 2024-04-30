package com.example.flipDeal.Service.StrategyInterface;

import com.example.flipDeal.dtos.Discount;
import com.example.flipDeal.dtos.Product;
import org.springframework.stereotype.Component;

@Component("PROMOTIONSETA")
public class PromotionSetA implements PromotionStrategy {

    @Override
    public Discount calculateDiscount(Product product) {
        double discount = 0.0;
        String Promotion_Tag = "";
        Discount discountDetails = new Discount();
        if (product.getOrigin().equals("Africa")) {
            int price1 = product.getPrice();
            discount = price1 - 0.07 * price1;
            product.setPrice((int) discount);
            Promotion_Tag = "GET 7 % OFF";

        }
        if (product.getRating() == 2) {
            int priceWhenRatingIsEqualto2 = product.getPrice();
            if (discount < 0.04 * priceWhenRatingIsEqualto2) {
                discount = priceWhenRatingIsEqualto2 - 0.04 * priceWhenRatingIsEqualto2;
                Promotion_Tag = "GET 4 % OFF";
            }

        } else if (product.getRating() < 2) {
            int priceWhenRatingIsLessthan2 = product.getPrice();
            if (discount < 0.08 * priceWhenRatingIsLessthan2) {
                discount = priceWhenRatingIsLessthan2 - 0.08 * priceWhenRatingIsLessthan2;
                Promotion_Tag = "GET 8 % OFF";
            }

        }
        if (product.getCategory() == "electronics" && product.getCategory() == "furnishing" && product.getPrice() >= 500) {
            int price = product.getPrice();
            if (discount < price - 100) {
                discount = price - 100;
                Promotion_Tag = "GET  OFF BY 100 ";
            }


        }
        discountDetails.setDiscount_tag(Promotion_Tag);
        discountDetails.setAmount(discount);
        return discountDetails;
    }
}





