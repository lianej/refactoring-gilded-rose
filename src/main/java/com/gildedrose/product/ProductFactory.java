package com.gildedrose.product;

import com.gildedrose.product.qgp.NoLimitOfQualityGuaranteePeriod;
import com.gildedrose.product.qgp.NormalQualityGuaranteePeriod;
import com.gildedrose.product.value.AgedProductValue;
import com.gildedrose.product.value.BackstagePassesProductValue;
import com.gildedrose.product.value.ConstantProductValue;
import com.gildedrose.product.value.NormalProductValue;

public class ProductFactory {
    public static final String PRODUCT_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String PRODUCT_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";

    public static Product newProduct(String name, int qualityGuaranteePeriod, int value) {
        switch (name) {
            case PRODUCT_SULFURAS:
                return new Product(name, new NoLimitOfQualityGuaranteePeriod(qualityGuaranteePeriod), new ConstantProductValue(value));
            case PRODUCT_BACKSTAGE_PASSES:
                NormalQualityGuaranteePeriod period = new NormalQualityGuaranteePeriod(qualityGuaranteePeriod);
                return new Product(name, period, new BackstagePassesProductValue(value, period));
            case PRODUCT_AGED_BRIE:
                return new Product(name, new NormalQualityGuaranteePeriod(qualityGuaranteePeriod), new AgedProductValue(value));
            default:
                return new Product(name, new NormalQualityGuaranteePeriod(qualityGuaranteePeriod), new NormalProductValue(value));
        }
    }
}
