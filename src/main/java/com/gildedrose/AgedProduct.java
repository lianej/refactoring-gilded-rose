package com.gildedrose;

public class AgedProduct extends Product {

    public AgedProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, qualityGuaranteePeriod, value);
    }

    @Override
   protected void updateValueIfExpiration() {
        productValue.upgrade(1);
    }

    @Override
    protected void updateValueBeforeQualityGuaranteePeriodUpdated() {
        productValue.upgrade(1);
    }
}
