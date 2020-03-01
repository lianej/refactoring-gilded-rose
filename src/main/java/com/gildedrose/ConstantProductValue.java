package com.gildedrose;

public class ConstantProductValue extends ProductValue {
    public ConstantProductValue(int value) {
        super(value);
    }

    @Override
    public void update() {
        //do nothing
    }

    @Override
    public void updateIfExpiration() {
        //do nothing
    }
}
