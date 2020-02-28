package com.gildedrose;

public class AgedProduct extends Item{

    public AgedProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, qualityGuaranteePeriod, value);
    }

    @Override
    void updateValueIfExpiration() {
        upgradeValue();
    }

    @Override
    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        upgradeValue();
    }
}
