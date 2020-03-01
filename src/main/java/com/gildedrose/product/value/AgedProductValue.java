package com.gildedrose.product.value;

public class AgedProductValue extends NormalProductValue {

    public AgedProductValue(int value) {
        super(value);
    }

    @Override
    public void update() {
        upgrade(1);
    }

    @Override
    public void updateIfExpiration() {
        upgrade(1);
    }
}
