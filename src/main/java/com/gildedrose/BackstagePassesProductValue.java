package com.gildedrose;

public class BackstagePassesProductValue extends ProductValue {
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
