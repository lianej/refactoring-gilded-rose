package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GildedRoseTest {

    @Test
    public void foo() {
        Item item = updateQuality(new Item("foo", 1, 5));
        assertEquals("foo", item.name);
        assertEquals(item.quality, 4);
        assertEquals(item.sell_in, 0);
    }

    @Test
    void supportability_test() {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        app.update_quality();
        assertEquals("[+5 Dexterity Vest, 9, 19, Aged Brie, 1, 1, Elixir of the Mongoose, 4, 6, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 14, 21, Backstage passes to a TAFKAL80ETC concert, 9, 50, Backstage passes to a TAFKAL80ETC concert, 4, 50, Backstage passes to a TAFKAL80ETC concert, 0, 23, Conjured Mana Cake, 2, 5]",
                Arrays.toString(app.items));

        app.update_quality();
        assertEquals("[+5 Dexterity Vest, 8, 18, Aged Brie, 0, 2, Elixir of the Mongoose, 3, 5, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 13, 22, Backstage passes to a TAFKAL80ETC concert, 8, 50, Backstage passes to a TAFKAL80ETC concert, 3, 50, Backstage passes to a TAFKAL80ETC concert, -1, 0, Conjured Mana Cake, 1, 4]",
                Arrays.toString(app.items));

        app.update_quality();
        assertEquals("[+5 Dexterity Vest, 7, 17, Aged Brie, -1, 4, Elixir of the Mongoose, 2, 4, Sulfuras, Hand of Ragnaros, 0, 80, Sulfuras, Hand of Ragnaros, -1, 80, Backstage passes to a TAFKAL80ETC concert, 12, 23, Backstage passes to a TAFKAL80ETC concert, 7, 50, Backstage passes to a TAFKAL80ETC concert, 2, 50, Backstage passes to a TAFKAL80ETC concert, -2, 0, Conjured Mana Cake, 0, 3]",
                Arrays.toString(app.items));
    }

    private Item updateQuality(Item item) {
        Item[] items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.update_quality();
        return app.items[0];
    }


}
