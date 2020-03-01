package com.gildedrose.product.value;

import lombok.Getter;

public class ProductValue {
    @Getter
    public int value;
    public int minValue = 0;
    public int maxValue = 50;

    public ProductValue(int value) {
        this.value = value;
    }

    protected final void upgrade(int delta) {
        this.value = Math.min(this.maxValue, this.value + delta);
    }

    protected final void downgrade(int delta) {
        this.value = Math.max(this.minValue, this.value - delta);
    }

    protected final void lossValue(){
        this.value = minValue;
    }

    public void update(){
        downgrade(1);
    }

    public void updateIfExpiration(){
        downgrade(1);
    }
}
