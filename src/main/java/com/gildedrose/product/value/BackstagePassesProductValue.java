package com.gildedrose.product.value;

import com.gildedrose.product.qgp.QualityGuaranteePeriod;

public class BackstagePassesProductValue extends NormalProductValue {
    private QualityGuaranteePeriod qualityGuaranteePeriod;

    public BackstagePassesProductValue(int value, QualityGuaranteePeriod qualityGuaranteePeriod) {
        super(value);
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public void update(){
        int qualityGuaranteePeriod = this.qualityGuaranteePeriod.getRemainingDays();
        if (qualityGuaranteePeriod < 6) {
            this.upgrade(3);
        } else if (qualityGuaranteePeriod < 11) {
            this.upgrade(2);
        } else {
            this.upgrade(1);
        }
    }

    @Override
    public void updateIfExpiration() {
        lossValue();
    }
}
