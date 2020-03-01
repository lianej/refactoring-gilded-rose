package com.gildedrose.product.qgp;

import lombok.Getter;

@Getter
public class NormalQualityGuaranteePeriod implements QualityGuaranteePeriod {
    private int remainingDays;

    public NormalQualityGuaranteePeriod(int days) {
        this.remainingDays = days;
    }

    @Override
    public void update(){
       this.remainingDays -= 1;
    }

    @Override
    public boolean isExpired() {
        return this.remainingDays < 0;
    }
}
