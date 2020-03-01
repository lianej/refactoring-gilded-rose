package com.gildedrose;

import lombok.Getter;

public class ProductValue {
    @Getter
    public int value;
    public int minValue = 0;
    public int maxValue = 50;

    public ProductValue(int value) {
        this.value = value;
    }

    public void upgrade(int delta) {
        this.value = Math.min(this.maxValue, this.value + delta);
    }

    public void downgrade(int delta) {
        this.value = Math.max(this.minValue, this.value - delta);
    }

    public void lossValue(){
        this.value = minValue;
    }

    public void update(){
        downgrade(1);
    }

    public void updateIfExpiration(){
        downgrade(1);
    }
}
