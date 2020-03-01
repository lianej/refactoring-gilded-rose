package com.gildedrose;

public class EquipmentProduct extends Product {
    public EquipmentProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new NoLimitOfQualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new ConstantProductValue(value);
    }

}
