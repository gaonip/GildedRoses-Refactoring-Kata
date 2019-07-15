package com.gildedrose

/**
  * A class to represent the "Gilded Rose" system dealing with its items.
  *
  * @param items Array with items.
  */
class GildedRose(val items: Array[Item]) {

  /**
    * UpdateQuality method to update quality on items.
    */

  def updateQuality() = {
    items.map(item => {
      Item.apply(item)
    }).foreach(Item => {
      Item.update()
    })
  }
}

