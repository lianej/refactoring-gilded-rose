package com.gildedrose;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;



    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateValueOfItems() {
        Stream.of(items).forEach(Item::updateValue);
    }

}
