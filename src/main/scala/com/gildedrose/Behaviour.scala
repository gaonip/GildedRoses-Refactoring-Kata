package com.gildedrose

/**
  * Abstract class defining the behaviour of an item, which contains the update method
  * and the updateQualityValue and updateSellinValue abstract methods.
  *
  * @param item
  */

abstract class Behaviour(item: Item) {

  val maxQuality = 50

  /**
    * The update method calls the updateQualityValue and updateSellinValue methods
    * and is always a poitive value limited by the maxQualityValue.
    */
  def update(): Unit = {
    updateQualityValue
    updateSellinValue

    if (item.quality > maxQuality) {
      item.quality = maxQuality
    }

    if (item.quality < 0) {
      item.quality = 0
    }
  }

  protected def updateQualityValue

  protected def updateSellinValue
}

/**
  * The class that describes behaviour for items that fare better over age.
  *
  * @param item
  */
class AgedBehaviour(item: Item) extends Behaviour(item) {

  override def updateQualityValue() = {
    item.quality += 1
  }

  override def updateSellinValue() = {
    item.sellIn -= 1

    if (item.sellIn < 0) {
      item.quality += 1
    }
  }
}

/**
  * The class that describes behaviour for items that are legendary and hence don't degrade and don't sell.
  *
  * @param item
  */
class LegendaryBehaviour(item: Item) extends Behaviour(item) {
  override def update(): Unit = {}

  override def updateQualityValue(): Unit = {}

  override def updateSellinValue(): Unit = {}
}

/**
  * The class that describes behaviour for items that become more valuable when sellIn days decrease, but
  * drop to zero when the sellIn date as passed.
  *
  * @param item
  */

class BackstageBehaviour(item: Item) extends Behaviour(item) {

  val tenDaysSellin = 11
  val fiveDaysSellin = 6

  override def updateQualityValue() = {
    item.quality += 1

    if (item.sellIn < tenDaysSellin) {
      item.quality += 1
    }

    if (item.sellIn < fiveDaysSellin) {
      item.quality += 1
    }
  }

  override def updateSellinValue() = {
    item.sellIn -= 1
    if (item.sellIn < 0) {
      item.quality = 0
    }
  }
}

/**
  * The class that descrtibes behaviour for items that degrade twice as fast as regular items.
  *
  * @param item
  */
class ConjuredBehaviour(item: Item) extends Behaviour(item) {
  override def updateQualityValue() = {
    item.quality -= 2
    if (item.sellIn < 0) {
      item.quality -= 2
    }
  }

  override def updateSellinValue() = {
    item.sellIn -= 1
  }
}

/**
  * The class that implements default behaviour that items reduce in quality and sellInvalue.
  *
  * @param item
  */
class DefaultBehaviour(item: Item) extends Behaviour(item) {
  override def updateQualityValue() = {
    item.quality -= 1
    if (item.sellIn < 0) {
      item.quality -= 1
    }
  }

  override def updateSellinValue() = {
    item.sellIn -= 1
  }

}

