package com.gildedrose;

public class EquipmentProduct extends Product {
    public EquipmentProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, new NoLimitOfQualityGuaranteePeriod(qualityGuaranteePeriod), new ProductValue(value));
    }

    @Override
    void updateValueIfExpiration() {
        //do nothing
    }

    @Override
    void updateQualityGuaranteePeriod() {
        //do nothing
    }

    @Override
    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        //do nothing
    }
}
