package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    protected String name;

    protected int qualityGuaranteePeriod;

    protected int value;

    public static final String PRODUCT_SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String PRODUCT_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String PRODUCT_AGED_BRIE = "Aged Brie";

    public static Item newItem(String name, int qualityGuaranteePeriod, int value) {
        switch (name) {
            case PRODUCT_SULFURAS:
                return new EquipmentProduct(name, qualityGuaranteePeriod, value);
            case PRODUCT_BACKSTAGE_PASSES:
                return new BackstagePassesProduct(name, qualityGuaranteePeriod, value);
            case PRODUCT_AGED_BRIE:
                return new AgedProduct(name, qualityGuaranteePeriod, value);
            default:
                return new Item(name, qualityGuaranteePeriod, value);
        }
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod + ", " + this.value;
    }

    void downgradeValue() {
        if (value > 0) {
            value--;
        }
    }

    void upgradeValue() {
        if (value < 50) {
            value++;
        }
    }

    void decrementQualityGuaranteePeriod() {
        qualityGuaranteePeriod = getQualityGuaranteePeriod() - 1;
    }

    void updateValueIfExpiration() {
        downgradeValue();
    }

    void updateQualityGuaranteePeriod() {
        decrementQualityGuaranteePeriod();
    }

    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        downgradeValue();
    }

    void updateValue() {
        updateValueBeforeQualityGuaranteePeriodUpdated();

        updateQualityGuaranteePeriod();

        if (getQualityGuaranteePeriod() < 0) {
            updateValueIfExpiration();
        }
    }
}
