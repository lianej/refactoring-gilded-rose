package com.gildedrose;

public class AgedProductValue extends ProductValue {

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
