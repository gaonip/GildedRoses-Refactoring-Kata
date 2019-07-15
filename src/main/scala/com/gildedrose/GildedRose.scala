package com.gildedrose

/**
  * A class to represent the "Gilded Rose" system dealing with its items.
  *
  * @param items Array with items.
  */
class GildedRose(val items: Array[Item]) {


  val maxQuality = 50
  val tenDaysSellin = 10
  val fiveDaysSellin = 5

  /**
    * @param item        The item to be checked.
    * @param updateValue The quality update value.
    * @param maxQuality  The maximum threshold value.
    * @return Returns the item making sure that a given threshold value is never exceeded.
    */
  def setMaxQuality(item: Item, updateValue: Int, maxQuality: Int): Item = {

    item.quality += updateValue
    item.quality = item.quality min maxQuality
    item
  }

  /**
    * Refactored original function to update quality on items.
    */
  def updateQuality(): Unit = {

    items.foreach {
      case item@Item("Sulfuras, Hand of Ragnaros", _, _) =>
      case item@Item("Aged Brie", sellIn, quality) if (quality <= maxQuality && sellIn >= 0) =>
        item.sellIn -= 1
        setMaxQuality(item, 1, maxQuality)
      case item@Item("Aged Brie", sellIn, quality) if (quality <= maxQuality && sellIn < 0) =>
        item.sellIn -= 1
        setMaxQuality(item, 2, maxQuality)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if (quality <= maxQuality && sellIn > tenDaysSellin) =>
        item.sellIn -= 1
        setMaxQuality(item, 1, maxQuality)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if (quality <= maxQuality && sellIn > fiveDaysSellin) =>
        item.sellIn -= 1
        setMaxQuality(item, 2, maxQuality)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) if (quality <= maxQuality && sellIn >= 0) =>
        item.sellIn -= 1
        setMaxQuality(item, 3, maxQuality)
      case item@Item("Backstage passes to a TAFKAL80ETC concert", sellIn, _) if sellIn < 0 =>
        item.sellIn -= 1
        item.quality = 0
      case item@Item("conjured", sellIn, quality) if (quality > 0 && sellIn >= 0) =>
        item.sellIn -= 1
        item.quality -= 2
      case item@Item("conjured", sellIn, quality) if (quality > 0 && sellIn < 0) =>
        item.sellIn -= 1
        item.quality -= 4
      case item@Item(_, sellIn, quality) if (quality > 0 && sellIn >= 0) =>
        item.sellIn -= 1
        item.quality -= 1
      case item@Item(_, sellIn, quality) if (quality > 0 && sellIn < 0) =>
        item.sellIn -= 1
        item.quality -= 2
      case _ =>
    }
  }

}



