package com.gildedrose;

public class BackstagePassesProduct extends Product {
    public BackstagePassesProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, qualityGuaranteePeriod, value);
    }

    @Override
    void updateValueIfExpiration() {
        productValue.lossValue();
    }

    @Override
    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        int qualityGuaranteePeriod = getQualityGuaranteePeriodObject().getRemainingDays();
        if (qualityGuaranteePeriod < 6) {
            productValue.upgrade(3);
        } else if (qualityGuaranteePeriod < 11) {
            productValue.upgrade(2);
        } else {
            productValue.upgrade(1);
        }

    }

}
