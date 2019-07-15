package com.gildedrose

case class Item(val name: String, var sellIn: Int, var quality: Int)

object ItemWithBehaviour {
  def create(item: Item): Behaviour = item.name match {
    case "Sulfuras, Hand of Ragnaros" =>  new LegendaryBehaviour(item)
    case "Aged Brie" =>  new AgedBehaviour(item)
    case "Backstage passes to a TAFKAL80ETC concert" => new BackstageBehaviour(item)
    case "conjured" =>  new ConjuredBehaviour(item)
    case _ =>  new DefaultBehaviour(item)
  }
}