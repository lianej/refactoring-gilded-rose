package com.gildedrose.product;

import com.gildedrose.product.qgp.NormalQualityGuaranteePeriod;
import com.gildedrose.product.qgp.QualityGuaranteePeriod;
import com.gildedrose.product.value.NormalProductValue;
import com.gildedrose.product.value.ProductValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Product {

    protected String name;

    protected QualityGuaranteePeriod qualityGuaranteePeriod;

    protected ProductValue productValue;

    public int getProductValue() {
        return productValue.getValue();
    }

    public Product(String name, int qualityGuaranteePeriod, int productValue) {
        this.name = name;
        this.qualityGuaranteePeriod = new NormalQualityGuaranteePeriod(qualityGuaranteePeriod);
        this.productValue = new NormalProductValue(productValue);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.qualityGuaranteePeriod.getRemainingDays() + ", " + this.productValue.getValue();
    }

    public void updateValue() {
        productValue.update();

        qualityGuaranteePeriod.update();

        if (qualityGuaranteePeriod.isExpired()) {
            productValue.updateIfExpiration();
        }
    }

}
