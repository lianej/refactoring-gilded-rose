package com.gildedrose;

public class AgedProduct extends Product {

    public AgedProduct(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = new QualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new AgedProductValue(value);
    }

}
