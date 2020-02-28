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
            if (item.isProductOf(PRODUCT_AGED_BRIE) || item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            } else if (item.isProductOf(PRODUCT_SULFURAS)) {
                // empty
            } else {
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }
            }

            if (item.isProductOf(PRODUCT_SULFURAS)) {
            } else {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (item.isProductOf(PRODUCT_AGED_BRIE)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else if (item.isProductOf(PRODUCT_BACKSTAGE_PASSES)) {
                    item.quality = 0;
                } else if (item.isProductOf(PRODUCT_SULFURAS)) {
                    // empty
                } else {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }

            }
        }
    }

}
