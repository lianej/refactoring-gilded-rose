package com.gildedrose;

import com.gildedrose.product.Product;
import com.gildedrose.product.ProductFactory;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Product[] products = new Product[] {
                ProductFactory.newProduct("+5 Dexterity Vest", 10, 20), //
                ProductFactory.newProduct("Aged Brie", 2, 0), //
                ProductFactory.newProduct("Elixir of the Mongoose", 5, 7), //
                ProductFactory.newProduct("Sulfuras, Hand of Ragnaros", 0, 80), //
                ProductFactory.newProduct("Sulfuras, Hand of Ragnaros", -1, 80),
                ProductFactory.newProduct("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                ProductFactory.newProduct("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                ProductFactory.newProduct("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                ProductFactory.newProduct("Backstage passes to a TAFKAL80ETC concert", 1, 20),
                // this conjured item does not work properly yet
                ProductFactory.newProduct("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(products);

        int days = 3;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println();
            app.updateValueOfItems();
        }
    }

}
