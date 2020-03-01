package com.gildedrose.product;

import com.gildedrose.product.qgp.NoLimitOfQualityGuaranteePeriod;
import com.gildedrose.product.value.ConstantProductValue;

public class EquipmentProduct extends Product {
    public EquipmentProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new NoLimitOfQualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new ConstantProductValue(value);
    }

}
