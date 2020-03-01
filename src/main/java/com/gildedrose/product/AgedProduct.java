package com.gildedrose.product;

import com.gildedrose.product.qgp.QualityGuaranteePeriod;
import com.gildedrose.product.value.AgedProductValue;

public class AgedProduct extends Product {

    public AgedProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new QualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new AgedProductValue(value);
    }

}
