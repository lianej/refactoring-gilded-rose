package com.gildedrose;

class GildedRose {
    Item[] items;

    public static final String PRODUCT_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String PRODUCT_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item.isProductOf(PRODUCT_AGED_BRIE)) {
                item.upgradeQualityIfLessThanLimit();
            } else if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
                if (item.value < 50) {
                    item.incrementQuality();
                    if (item.qualityGuaranteePeriod < 11) {
                        item.upgradeQualityIfLessThanLimit();
                    }
                    if (item.qualityGuaranteePeriod < 6) {
                        item.upgradeQualityIfLessThanLimit();
                    }
                }
            } else if (item.isProductOf(PRODUCT_SULFURAS)) {
                // empty
            } else {
                item.decrementQuality();
            }

            if (item.isProductOf(PRODUCT_SULFURAS)) {
            } else {
                item.qualityGuaranteePeriod = item.qualityGuaranteePeriod - 1;
            }

            if (item.qualityGuaranteePeriod < 0) {
                if (item.isProductOf(PRODUCT_AGED_BRIE)) {
                    item.upgradeQualityIfLessThanLimit();
                } else if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
                    item.value = 0;
                } else if (item.isProductOf(PRODUCT_SULFURAS)) {
                    // empty
                } else {
                    item.decrementQuality();
                }

            }
        }
    }

}
