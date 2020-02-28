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
        int valueDelta = calculateValueOfUpgrade();
        productValue.upgrade(valueDelta);

    }

    private int calculateValueOfUpgrade() {
        int qualityGuaranteePeriod = getQualityGuaranteePeriod();
        if (qualityGuaranteePeriod < 6) {
            return 3;
        } else if (qualityGuaranteePeriod < 11) {
            return 2;
        } else {
            return 1;
        }
    }
}
