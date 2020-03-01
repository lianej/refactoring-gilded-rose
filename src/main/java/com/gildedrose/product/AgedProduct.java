package com.gildedrose.product;

import com.gildedrose.product.qgp.NormalQualityGuaranteePeriod;
import com.gildedrose.product.qgp.QualityGuaranteePeriod;
import com.gildedrose.product.value.AgedProductValue;

public class AgedProduct extends Product {

    public AgedProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new NormalQualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new AgedProductValue(value);
    }

}
