package com.gildedrose;

public class EquipmentProduct extends Product {
    public EquipmentProduct(String name, int qualityGuaranteePeriod, int value) {
        super(name, new NoLimitOfQualityGuaranteePeriod(qualityGuaranteePeriod), new ProductValue(value));
    }

    @Override
    protected void updateValueIfExpiration() {
        //do nothing
    }

    @Override
    protected void updateQualityGuaranteePeriod() {
        //do nothing
    }

    @Override
    protected void updateValueBeforeQualityGuaranteePeriodUpdated() {
        //do nothing
    }
}
