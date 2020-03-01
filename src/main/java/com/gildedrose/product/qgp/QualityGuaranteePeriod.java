package com.gildedrose.product.qgp;

public interface QualityGuaranteePeriod {
    void update();

    boolean isExpired();

    int getRemainingDays();
}
