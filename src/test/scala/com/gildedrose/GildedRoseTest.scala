package com.gildedrose

import org.scalatest._

/**
  * A test class to test functionality of the GildedRose
  * The test style used is Funspec
  * The BeforeandAftereach trait makes sure our variables are reinitialized before each test
  */
class GildedRoseTest extends FunSpec with BeforeAndAfterEach {

  /**
    * Initialize before each test re-assignable variables and mutable objects.
    */
  var regular, agedBrie, sulfuras, backstage, conjured: Item = _
  var rose: GildedRose = _

  override def beforeEach(): Unit = {
    regular = Item("regular", 5, 5)
    agedBrie = Item("Aged Brie", 10, 10)
    sulfuras = Item("Sulfuras, Hand of Ragnaros", 20, 80)
    backstage = Item("Backstage passes to a TAFKAL80ETC concert", 11, 8)
    conjured = Item("conjured", 10, 10)

    rose = new GildedRose(Array(regular, agedBrie, sulfuras, backstage, conjured))
  }

  /**
    * Testing gilded rose items
    */
  describe("GildedRose") {

    it("should degrade items in quality by one") {
      rose.updateQuality()
      assert(regular.quality == 4)
    }

    it("should reduce items in sellIn by one") {
      rose.updateQuality()
      assert(regular.sellIn == 4)
    }

    it("should degrade twice as fast once sellIn has passed") {
      regular.sellIn = -1
      rose.updateQuality()
      assert(regular.quality == 3)
    }

    it("should not have a quality lower than zero") {
      regular.quality = 0
      rose.updateQuality()
      assert(regular.quality == 0)
    }

    it("should make sure aged brie increases in quality the older it gets") {
      rose.updateQuality()
      assert(agedBrie.quality == 11)
    }

    it("should make sure aged brie increases in quality again (+1 +1) as SellIn value <0") {
      agedBrie.sellIn = -1
      rose.updateQuality()
      assert(agedBrie.quality == 12)
    }

    it("should make sure quality of an item never is more than 50") {
      agedBrie.quality = 50
      rose.updateQuality()
      assert(agedBrie.quality == 50)
    }

    it("should make sure sulfuras never degrades in quality or be sold") {
      rose.updateQuality()
      assert(sulfuras.quality == 80 && sulfuras.sellIn == 20)
    }

    it("should make sure backstage pass quality increases when the sellIn value > 10") {
      rose.updateQuality()
      assert(backstage.quality == 9)
    }

    it("should make sure backstage pass quality increases by 2 when the sellIn value > 5") {
      backstage.sellIn = 10
      rose.updateQuality()
      assert(backstage.quality == 10)
    }

    it("should make sure backstage pass quality increases by 3 when the sellIn value > 0") {
      backstage.sellIn = 5
      rose.updateQuality()
      assert(backstage.quality == 11)
    }

    it("should make sure backstage pass quality drops to 0 when the sellIn value passes 0") {
      backstage.sellIn = -1
      rose.updateQuality()
      assert(backstage.quality == 0)
    }

    it("should make sure conjured items degrade twice as fast") {
      rose.updateQuality()
      assert(conjured.quality == 8)
    }

    it("should make sure conjured items degrade twice as fast (-2 -2) if sellIn <0)") {
      conjured.sellIn = -1
      rose.updateQuality()
      assert(conjured.quality == 6)
    }


  }

}