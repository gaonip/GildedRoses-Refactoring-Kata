# Gilded Rose refactoring Kata #

This is my refactoring solution of the Gilded Rose Kata in scala.
The initial assignment and requirements can be found on the following link: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt

## Refactoring using pattern matching
- First unit tests with FunSpec testing style, were run to assess whether the original code was working correctly as well as a way to understanding the requirements in code.
- After making sure all unit tests passed, the next step was drawing a flow diagram (on paper) to understand exactly the functionality of the GildedRoses' updateQuality method.
- Next, a readable and powerful way to refactor our nest if/else conditions is pattern matching. By doing this our code becomes much more simple, readable and extendable.
- Finally, after making sure the pattern matching method passed all our unit tests,  we add a new "conjured" unit test and item.