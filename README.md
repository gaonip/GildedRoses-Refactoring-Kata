# Gilded Rose refactoring Kata #

This is my refactoring solution of the Gilded Rose Kata in scala.
The initial assignment, requirements and constraints can be found on the following link: https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt

## Analysis of the original code
- Nested if-else conditions makes code complex, difficult to read and unmaintainable.
- The rules specified within the requirements are difficult to identify in the code.
- The usage of hardcoded values is not good practice.


## General steps to refactor
- The general approach was to make sure we always have a deployable version of the code by doing TDD.
- First, unit tests with FunSpec testing style, were run to assess whether the original code was working correctly as well as to understand the requirements in code.
- After making sure all unit tests passed, the next step was drawing a flow diagram (on paper) to understand exactly the functionality of the GildedRoses' updateQuality method.
- Next, we notice that the rules to be applied depend on the description given field of an item, hence we could use pattern matching. By doing this, our code becomes much less complex, more readable and extendable.
- Finally, after making sure the new updateQuality method passed all our unit tests,  we add a new "conjured" unit test and item.