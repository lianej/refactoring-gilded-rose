package com.gildedrose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String name;

    private int qualityGuaranteePeriod;

    private int value;

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod + ", " + this.value;
    }

    boolean isProductOf(String name) {
        return this.name.equals(name);
    }

    void incrementValue() {
        value++;
    }

    void decrementValue() {
        if (value > 0) {
            value--;
        }
    }

    void upgradeValueIfLessThanLimit() {
        if (value < 50) {
            incrementValue();
        }
    }

    void decrementQualityGuaranteePeriod() {
        qualityGuaranteePeriod = getQualityGuaranteePeriod() - 1;
    }
}
