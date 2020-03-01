package com.gildedrose;

import lombok.Getter;

@Getter
public class QualityGuaranteePeriod {
    private int remainingDays;

    public QualityGuaranteePeriod(int days) {
        this.remainingDays = days;
    }

    public void decrease(){
       this.remainingDays -= 1;
    }

    public boolean isExpired() {
        return this.remainingDays < 0;
    }
}
