package com.gildedrose

class GildedRose(val items: Array[Item]) {

  // Original function to update quality
  def updateQuality() {
    for (i <- 0 until items.length) {
      if (!items(i).name.equals("Aged Brie")
        && !items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (items(i).quality > 0) {
          if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
            items(i).quality = items(i).quality - 1
          }
        }
      } else {
        if (items(i).quality < 50) {
          items(i).quality = items(i).quality + 1

          if (items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items(i).sellIn < 11) {
              if (items(i).quality < 50) {
                items(i).quality = items(i).quality + 1
              }
            }

            if (items(i).sellIn < 6) {
              if (items(i).quality < 50) {
                items(i).quality = items(i).quality + 1
              }
            }
          }
        }
      }

      if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
        items(i).sellIn = items(i).sellIn - 1
      }

      if (items(i).sellIn < 0) {
        if (!items(i).name.equals("Aged Brie")) {
          if (!items(i).name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (items(i).quality > 0) {
              if (!items(i).name.equals("Sulfuras, Hand of Ragnaros")) {
                items(i).quality = items(i).quality - 1
              }
            }
          } else {
            items(i).quality = items(i).quality - items(i).quality
          }
        } else {
          if (items(i).quality < 50) {
            items(i).quality = items(i).quality + 1
          }
        }
      }
    }
  }

  // Function to make sure a given threshold value is never exceeded
  def set_max_quality(item: Item, updateValue:Int, max_quality : Int) : Item = {

    item.quality += updateValue
    item.quality = item.quality min max_quality
    item
  }

  // Refactored original function to update quality
  def updateQuality2(): Unit ={
    items.foreach {
      case item@Item("Sulfuras, Hand of Ragnaros", _, _) => //do nothing
      case item@Item("Aged Brie", sellIn, quality) if quality <= 50 & sellIn >= 0 =>
        item.sellIn -= 1
        //item.quality += 1
        set_max_quality(item, 1, 50)
      case item@Item("Aged Brie", sellIn, quality) if quality <= 50 & sellIn < 0 =>
        item.sellIn -= 1
        set_max_quality(item, 2, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 10 =>
        item.sellIn -= 1
        set_max_quality(item, 1, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 5 =>
        item.sellIn -= 1
        set_max_quality(item, 2, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if quality < 50 && sellIn > 0 =>
        item.sellIn -= 1
        set_max_quality(item, 3, 50)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, _) if sellIn <= 0 =>
        item.sellIn -= 1
        item.quality = 0
      case item@Item("conjured", sellIn, quality) if quality > 0 && sellIn > 0 =>
        item.sellIn -= 1
        item.quality -= 2
      case item@Item("conjured", sellIn, quality) if quality > 0 && sellIn <= 0 =>
        item.sellIn -= 1
        item.quality -= 4
      case item@Item(_, sellIn, quality) if sellIn > 0 && quality > 0 =>
        item.sellIn -= 1
        item.quality -= 1
      case item@Item(_, sellIn, quality) if sellIn <= 0 && quality > 0 =>
        item.sellIn -= 1
        item.quality -= 2
      case _ =>
    }
  }

}

