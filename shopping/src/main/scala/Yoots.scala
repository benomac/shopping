object Yoots {
    
    case class Price (price: Int, numForDeal: Int, priceForDeal: Int)

  //Map of classes for item prices
  val prices = Map('a' -> Price(50, 3, 130), 
                    'b' -> Price(30, 2, 45), 
                    'c' -> Price(20, 0, 0), 
                    'd' -> Price(15, 0, 0))
    
    def priceForDeals (count: Int, products: Price): Int = {
    (count / products.numForDeal) * products.priceForDeal
  }

//   //Get the price for item that didnt make deal.
  def priceForNoDeals (count: Int, products: Price): Int = {
    (count % products.numForDeal) * products.price
  }

  //get the price for item that have no deal
  def priceWhenItemHasNoDealValues (count: Int, products: Price): Int = {
    count * products.price
  }

  //Remove invalid items and print a warning message
  def removeInvalidItems (items: String, products: Map[Char, Price]): String = {
      val valid = for (item <- items) yield {
          if(!prices.keySet.contains(item)) {
              //unit to be returned, have as many as you want!!!!!
              println(item  + " is an invalid item")
              //final return item from for loop!!!
              ""
          } else {
              item
          }
      }
      valid.mkString("")
  }

  //Function to create the tobuy map
  def createToBuyMap (items: String): Map[Char, Int] = {
      (for {
      x <- items
      i = items.count(_ == x) 
      } yield (x -> i)).toMap
    } 

    def total(vals: String, prod: Map[Char, Price]): String = {
      val tot = for ((key,value) <- createToBuyMap(vals)) yield {
        // add function to check  if item is valid 
        if(prices(key).numForDeal == 0) {
          (priceWhenItemHasNoDealValues(value, prod(key)))
        } else {
          priceForDeals(value, prices(key)) + priceForNoDeals(value, prod(key))
        }
      }
      val numTot = tot.sum
      "Total " + numTot
    }
  
    
}