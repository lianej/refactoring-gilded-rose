package com.gildedrose;

public class BackstagePassesProduct extends Item {
    public BackstagePassesProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, qualityGuaranteePeriod, value);
    }

    @Override
    void updateValueIfExpiration() {
        setValue(0);
    }

    @Override
    void updateValueBeforeQualityGuaranteePeriodUpdated() {

        upgradeValue();

        if (getQualityGuaranteePeriod() < 11) {
            upgradeValue();
        }
        if (getQualityGuaranteePeriod() < 6) {
            upgradeValue();
        }
    }
}
