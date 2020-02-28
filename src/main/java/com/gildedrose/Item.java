package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    boolean isProductOf(String name) {
        return this.name.equals(name);
    }

    void incrementQuality() {
        quality++;
    }

    void decrementQuality() {
        if (quality > 0) {
            quality--;
        }
    }

    void upgradeQualityIfLessThanLimit() {
        if (quality < 50) {
            incrementQuality();
        }
    }
}
