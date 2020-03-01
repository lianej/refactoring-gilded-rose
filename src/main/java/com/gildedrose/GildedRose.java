package com.gildedrose;

import com.gildedrose.product.Product;

import java.util.stream.Stream;

class GildedRose {
    Product[] products;

    public GildedRose(Product[] products) {
        this.products = products;
    }

    public void updateValueOfItems() {
        Stream.of(products).forEach(Product::updateValue);
    }

}
