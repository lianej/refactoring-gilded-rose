package com.gildedrose.product.qgp;

public class NoLimitOfQualityGuaranteePeriod extends NormalQualityGuaranteePeriod {
    public NoLimitOfQualityGuaranteePeriod(int days) {
        super(days);
    }

    @Override
    public void update() {
        //do nothing
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
