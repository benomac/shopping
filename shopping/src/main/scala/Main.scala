  object Main extends App {

    //make case class
    case class Price (price: Int, numForDeal: Int, priceForDeal: Int)

    //Map of classes for item prices
    val prices = Map('a' -> Price(50, 3, 130), 
                      'b' -> Price(30, 2, 45), 
                      'c' -> Price(20, 0, 0), 
                      'd' -> Price(15, 0, 0))

    
    //Get the price for any deals made
    def priceForDeals (count: Int, things: Price): Int = {
      (count / things.numForDeal) * things.priceForDeal
    }

    //Get the price for item that didnt make deal.
    def priceForNoDeals (count: Int, things: Price): Int = {
      (count % things.numForDeal) * things.price
    }

    //get the price for item that have no deal
    def priceWhenItemHasNoDealValues (count: Int, things: Price): Int = {
      count * things.price
    }

    //Check item is in the prices map
    def checkItemIsValid (item: Char): Boolean = {
        prices.keySet.contains(item)
    }
    
  
    //Create var for items to buy
    val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")
    
    // Map of things to buy, check and discards any invalid items.
    val tobuy =
    (for {
      x <- items
      i = items.count(_ == x) 
      //function to check if item is valid.
      if (checkItemIsValid(x))
    } yield (x -> i)).toMap

    //Display message if an invalid item is found
    for (item <- items) {
      if (!(checkItemIsValid(item))) {
        println(item + " is an invalid item.")
      }
    }
    
    //Loop over tobuy map using item price data from prices
    println("Total " + {
    for ((key,value) <- tobuy) yield {
        // add function to check  if item is valid 
        if(prices(key).numForDeal == 0) {
          (priceWhenItemHasNoDealValues(value, prices(key)))
        } else {
          priceForDeals(value, prices(key)) + priceForNoDeals(value, prices(key))
        }
      }
    }.sum)


  }