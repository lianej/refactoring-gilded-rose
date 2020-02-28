package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    protected String name;

    protected int qualityGuaranteePeriod;

    protected ProductValue productValue;

    public int getProductValue() {
        return productValue.getValue();
    }

    public Product(String name, int qualityGuaranteePeriod, int productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.productValue = new ProductValue(productValue);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod + ", " + this.productValue.value;
    }

    void decrementQualityGuaranteePeriod() {
        qualityGuaranteePeriod = getQualityGuaranteePeriod() - 1;
    }

    void updateValueIfExpiration() {
        productValue.downgrade(1);
    }

    void updateQualityGuaranteePeriod() {
        decrementQualityGuaranteePeriod();
    }

    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        productValue.downgrade(1);
    }

    void updateValue() {
        updateValueBeforeQualityGuaranteePeriodUpdated();

        updateQualityGuaranteePeriod();

        if (getQualityGuaranteePeriod() < 0) {
            updateValueIfExpiration();
        }
    }
}
