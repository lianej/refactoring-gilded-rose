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
            updateValue(item);

            updateQualityGuaranteePeriod(item);

            updateValueIfExpiration(item);
        }
    }

    private void updateValueIfExpiration(Item item) {
        if (item.getQualityGuaranteePeriod() >= 0) {
            return;
        }
        if (item.isProductOf(PRODUCT_AGED_BRIE)) {
            item.upgradeValueIfLessThanLimit();
        } else if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
            item.setValue(0);
        } else if (item.isProductOf(PRODUCT_SULFURAS)) {
            // empty
        } else {
            item.decrementValue();
        }

    }

    private void updateQualityGuaranteePeriod(Item item) {
        if (item.isProductOf(PRODUCT_SULFURAS)) {
            return;
        }
        item.decrementQualityGuaranteePeriod();
    }

    private void updateValue(Item item) {
        if (item.isProductOf(PRODUCT_AGED_BRIE)) {
            item.upgradeValueIfLessThanLimit();
        } else if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
            if (item.getValue() < 50) {
                item.incrementValue();
                if (item.getQualityGuaranteePeriod() < 11) {
                    item.upgradeValueIfLessThanLimit();
                }
                if (item.getQualityGuaranteePeriod() < 6) {
                    item.upgradeValueIfLessThanLimit();
                }
            }
        } else if (item.isProductOf(PRODUCT_SULFURAS)) {
            // empty
        } else {
            item.decrementValue();
        }
    }

}
