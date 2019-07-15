package com.gildedrose

/**
  *
  * @param name    name of the item.
  * @param sellIn  value denites the number of days we have to sell the item
  * @param quality value which denotes how valuable the item is.
  */
case class Item(val name: String, var sellIn: Int, var quality: Int)


/**
  * Create a companion object with factory method.
  */
object Item {
  def apply(item: Item): Behaviour = item.name match {
    case "Sulfuras, Hand of Ragnaros" => new LegendaryBehaviour(item)
    case "Aged Brie" => new AgedBehaviour(item)
    case "Backstage passes to a TAFKAL80ETC concert" => new BackstageBehaviour(item)
    case "conjured" => new ConjuredBehaviour(item)
    case _ => new DefaultBehaviour(item)
  }
}