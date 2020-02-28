package com.gildedrose;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    protected String name;

    protected int qualityGuaranteePeriod;

    protected ProductValue productValue;

    public int getProductValue() {
        return productValue.getValue();
    }

    public Item(String name, int qualityGuaranteePeriod, int productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
        this.productValue = new ProductValue(productValue);
    }

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
        return this.name + ", " + this.qualityGuaranteePeriod + ", " + this.productValue.value;
    }

    void decrementQualityGuaranteePeriod() {
        qualityGuaranteePeriod = getQualityGuaranteePeriod() - 1;
    }

    void updateValueIfExpiration() {
        productValue.downgrade(1);
    }

    void updateQualityGuaranteePeriod() {
        decrementQualityGuaranteePeriod();
    }

    void updateValueBeforeQualityGuaranteePeriodUpdated() {
        productValue.downgrade(1);
    }

    void updateValue() {
        updateValueBeforeQualityGuaranteePeriodUpdated();

        updateQualityGuaranteePeriod();

        if (getQualityGuaranteePeriod() < 0) {
            updateValueIfExpiration();
        }
    }
}
