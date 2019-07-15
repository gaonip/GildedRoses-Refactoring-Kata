package com.gildedrose


abstract class Behaviour(item: Item) {

  def update(): Unit = {
    updateQualityValue
    updateSellinValue

    if (item.quality > 50) {
      item.quality = 50
    }

    if (item.quality < 0) {
      item.quality = 0
    }
  }

  protected def updateQualityValue

  protected def updateSellinValue
}


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

class LegendaryBehaviour(item: Item) extends Behaviour(item) {
  override def update(): Unit = {}

  override def updateQualityValue(): Unit = {}

  override def updateSellinValue(): Unit = {}
}

class BackstageBehaviour(item: Item) extends Behaviour(item) {
  override def updateQualityValue() = {
    item.quality += 1

    if (item.sellIn < 11) {
      item.quality += 1
    }

    if (item.sellIn < 6) {
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

