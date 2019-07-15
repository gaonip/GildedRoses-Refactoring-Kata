# Gilded Rose refactoring Kata #

This is my refactoring solution of the Gilded Rose Kata in scala.
The initial assignment, requirements and constraints can be found on the following link: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt

## Analysis of the original code
- Nested if-else conditions makes code complex, difficult to read and unmaintainable.
- The rules specified within the requirements are difficult to identify inside the code.
- The usage of hardcoded threshold values is not preferred.


## General steps to refactor
- The general approach was to make sure we always have a deployable version of the code by doing TDD.
- First, unit tests with FunSpec testing style, were run to assess whether the original code was working correctly as well as to understand the requirements in code.
- After making sure all unit tests passed, the next step was drawing a flow diagram (on paper) to understand exactly the functionality of the GildedRoses' updateQuality method.
- Next, we notice that the rules to be applied depend on the 'name' given field of an item, hence we could use pattern matching. By doing this, our code becomes much less complex, more readable and extendable.
- After making sure the new updateQuality method passed all our unit tests,  we add a new "conjured" unit test and item.

## Second iteration to refactor
- The first approach worked fine, but isn't necessarily maintainable if extended with many items, where some might have similar behaviour, for this reason a more object oriented approach is taken.
- Here, we use a factory method which depending on the 'name' of the item, applies a different behaviour or quality updating strategy.
- This approach makes it possible to extend towards larger item inventories where similar updating strategies can be grouped.