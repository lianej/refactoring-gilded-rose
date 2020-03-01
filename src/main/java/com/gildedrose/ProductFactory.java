package com.gildedrose;

import com.gildedrose.product.AgedProduct;
import com.gildedrose.product.BackstagePassesProduct;
import com.gildedrose.product.EquipmentProduct;
import com.gildedrose.product.Product;

public class ProductFactory {
    public static final String PRODUCT_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String PRODUCT_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";

    public static Product newProduct(String name, int qualityGuaranteePeriod, int value) {
        switch (name) {
            case PRODUCT_SULFURAS:
                return new EquipmentProduct(name, qualityGuaranteePeriod, value);
            case PRODUCT_BACKSTAGE_PASSES:
                return new BackstagePassesProduct(name, qualityGuaranteePeriod, value);
            case PRODUCT_AGED_BRIE:
                return new AgedProduct(name, qualityGuaranteePeriod, value);
            default:
                return new Product(name, qualityGuaranteePeriod, value);
        }
    }
}
