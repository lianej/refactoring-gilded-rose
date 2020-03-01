package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    protected Product(String name, QualityGuaranteePeriod qualityGuaranteePeriod, ProductValue productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.productValue = productValue;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod.getRemainingDays() + ", " + this.productValue.value;
    }

    protected void updateValueIfExpiration() {
        productValue.downgrade(1);
    }

    protected void updateQualityGuaranteePeriod() {
        qualityGuaranteePeriod.decrease();
    }

    protected void updateValueBeforeQualityGuaranteePeriodUpdated() {
        productValue.downgrade(1);
    }

    public void updateValue() {
        updateValueBeforeQualityGuaranteePeriodUpdated();

        updateQualityGuaranteePeriod();

        if (qualityGuaranteePeriod.isExpired()) {
            updateValueIfExpiration();
        }
    }

}
