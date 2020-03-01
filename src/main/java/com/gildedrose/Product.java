package com.gildedrose;

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

    public Product(String name, int qualityGuaranteePeriod, int productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = new QualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new ProductValue(productValue);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod.getRemainingDays() + ", " + this.productValue.value;
    }

    public void updateValue() {
        productValue.update();

        qualityGuaranteePeriod.update();

        if (qualityGuaranteePeriod.isExpired()) {
            productValue.updateIfExpiration();
        }
    }

}
