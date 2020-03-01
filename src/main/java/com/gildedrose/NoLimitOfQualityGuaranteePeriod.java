package com.gildedrose;

public class NoLimitOfQualityGuaranteePeriod extends QualityGuaranteePeriod {
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
