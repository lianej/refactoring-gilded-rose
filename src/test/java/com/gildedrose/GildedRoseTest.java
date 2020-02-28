package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GildedRoseTest {

    @Test
    public void foo() {
        Item item = updateQuality(new Item("foo", 1, 5));
        assertEquals("foo", item.name);
        assertEquals(item.quality, 4);
        assertEquals(item.sell_in, 0);
    }

    private Item updateQuality(Item item) {
        Item[] items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        return app.items[0];
    }


}
