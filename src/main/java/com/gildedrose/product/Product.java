package com.gildedrose.product;

import com.gildedrose.product.qgp.QualityGuaranteePeriod;
import com.gildedrose.product.value.ProductValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    protected String name;

    protected QualityGuaranteePeriod qualityGuaranteePeriod;

    protected ProductValue productValue;

    public int getProductValue() {
        return productValue.getValue();
    }

    public Product(String name, QualityGuaranteePeriod qualityGuaranteePeriod, ProductValue productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.productValue = productValue;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod.getRemainingDays() + ", " + this.productValue.getValue();
    }

    public void updateValue() {
        productValue.update();

        qualityGuaranteePeriod.update();

        if (qualityGuaranteePeriod.isExpired()) {
            productValue.updateIfExpiration();
        }
    }

}
