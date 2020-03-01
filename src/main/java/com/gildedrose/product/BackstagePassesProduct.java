package com.gildedrose.product;

import com.gildedrose.product.qgp.QualityGuaranteePeriod;
import com.gildedrose.product.value.BackstagePassesProductValue;

public class BackstagePassesProduct extends Product {
    public BackstagePassesProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new QualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new BackstagePassesProductValue(value, this.qualityGuaranteePeriod);
    }

}
