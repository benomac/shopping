## Tech Test Checkout

Here is my interpretation of the solution for the **Checkout** Kata.

This is my first project in **Scala**. I found learning a new launguage, while trying to complete this kata quite difficult at times, but in the end, it was a very rewarding challenge.

The Kata is as follows:

Checkout Kata

Implement the code for a supermarket checkout that calculates the total price of a number of items. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store, we’ll use individual letters of the alphabet (A, B, C, and so on as the SKUs). Our goods are priced individually. In addition, some items are multi-priced: buy n of them, and they’ll cost you y. For example, item ‘A’ might cost 50 pence individually, but this week we have a special offer: buy three ‘A’s and they’ll cost you £1.30. In fact this week’s prices are:

```
Item    Unit Price  Special Price
A       50          3 for 130
B       30          2 for 45
C       20
D       15
```

Our checkout accepts items in any order, so that if we scan a B, an A, and another B, we’ll recognise the two B’s and price them at 45 (for a total price so far of 95). 

Extra points: Because the pricing changes frequently, we need to be able to pass in a set of pricing rules each time we start handling a checkout transaction.

We expect to be able to run your solution as a command line application.

### Running from the **command line**:- ###

`sbt run` - This will use the default hard coded prices, as in the table above.

`sbt 'run "e 30 0 0,f 20 2 30,g 30 4 100"'` - This will create a completely new Map of prices to select from. The correct formatting is important, any incorrect formatting will not be included in the new Map of prices, and display an error message. If there are no correcltly formatted prices, the programme will revert back to the hard coded prices.

### Running from **sbt shell**:- ###

`~run` - For hard coded prices.

`~run "e 30 0 0,f 20 2 30,g 30 4 100"` - To create new price list.

### Entering items to buy:- ###

When prompeted enter all items as one string, for example, `aabaca`. Anything not in the prices Map will be treated as an invalid item.


Thanks for taking the time to have a look.



