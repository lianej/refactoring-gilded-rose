package com.gildedrose;

public class Item {

    public String name;

    public int qualityGuaranteePeriod;

    public int value;

    public Item(String name, int qualityGuaranteePeriod, int value) {
        this.name = name;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod + ", " + this.value;
    }

    boolean isProductOf(String name) {
        return this.name.equals(name);
    }

    void incrementQuality() {
        value++;
    }

    void decrementQuality() {
        if (value > 0) {
            value--;
        }
    }

    void upgradeValueIfLessThanLimit() {
        if (value < 50) {
            incrementQuality();
        }
    }
}
