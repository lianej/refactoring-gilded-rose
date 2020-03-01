package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    protected String name;

    protected QualityGuaranteePeriod qualityGuaranteePeriodObject;

    protected ProductValue productValue;

    public int getProductValue() {
        return productValue.getValue();
    }

    public Product(String name, int qualityGuaranteePeriod, int productValue) {
        this.name = name;
        this.qualityGuaranteePeriodObject = new QualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new ProductValue(productValue);
    }

    protected Product(String name, QualityGuaranteePeriod qualityGuaranteePeriod, ProductValue productValue) {
        this.name = name;
        this.qualityGuaranteePeriodObject = qualityGuaranteePeriod;
        this.productValue = productValue;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriodObject.getRemainingDays() + ", " + this.productValue.value;
    }

    void updateValueIfExpiration() {
        productValue.downgrade(1);
    }

    void updateQualityGuaranteePeriod() {
        qualityGuaranteePeriodObject.decrease();
    }

    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        productValue.downgrade(1);
    }

    public void updateValue() {
        updateValueBeforeQualityGuaranteePeriodUpdated();

        updateQualityGuaranteePeriod();

        if (qualityGuaranteePeriodObject.getRemainingDays() < 0) {
            updateValueIfExpiration();
        }
    }
}
