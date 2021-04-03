import Main._

object Yoots {
    
  //Create case class of items.
  case class Price (price: Int, numForDeal: Int, priceForDeal: Int)

  //Map of classes for item prices. NO VARS!!!
  val prices = Map('a' -> Price(50, 3, 130), 
                    'b' -> Price(30, 2, 45), 
                    'c' -> Price(20, 0, 0), 
                    'd' -> Price(15, 0, 0))

  //Get the args and split them. new prices must be entered in this format:
  // "f 10 2 15,g 20 3 50,e 20 4 100"
  def getArgsAndSplit(args: Array[String]): Array[String] = {
    val newItems = args(0).split(",")
    newItems
  }

  //Get the split args and split them again !!
  def getSplitArgsAndSplitAgain(splitArgs: Array[String]):  Array[Array[String]] = {
      val splitList = for (i <- splitArgs) yield {
      i.split(" ")
    }
    splitList
  }

  
  //Checks for correctly formated items, then, make the newItems Map.
  def createTheNewItemsMap(arr: Array[Array[String]]): Map[Char,Yoots.Price] = {
    // (for {
    //   i <- arr
    //     _ = if (!(i.length == 4 && i(1).charAt(0).isDigit && i(2).charAt(0).isDigit && i(3).charAt(0).isDigit))
    //       println("Item " + "'" + i(0).charAt(0) + "'" + """| has been entered with the incorrect format!""".stripMargin)
    //     else () 
    //     x = Price(i(1).toInt, i(2).toInt, i(3).toInt)
    //   } yield (i(0)(0) -> x)).toMap
    // }


    // THIS WORKS!!????
    // command line run this "f 10 2 15,g 20 k j,' [0 k j" to test both parts of if/else or if/if
    //should only allow you to buy f.
    //no argument will use the hard coded prices
    (for {
      i <- arr
        _ = if (!(i.length == 4 && i(1).charAt(0).isDigit && i(2).charAt(0).isDigit && i(3).charAt(0).isDigit))
          println("Item " + "'" + i(0).charAt(0) + "'" + """| has been entered with the incorrect format!""".stripMargin)
        if (i.length == 4 && i(1).charAt(0).isDigit && i(2).charAt(0).isDigit && i(3).charAt(0).isDigit)
        x = Price(i(1).toInt, i(2).toInt, i(3).toInt)
      } yield (i(0)(0) -> x)).toMap
    }
  

  //Choose correct Map, coded or command line entered.
  def decideWhichMapToUse(args: Array[String]): Map[Char,Yoots.Price] = {
    if(args.length == 0) {
      prices
    } else {
      val newItemsSplit = getArgsAndSplit(args)
      val splitNewItems = getSplitArgsAndSplitAgain(newItemsSplit)
      val mapped = createTheNewItemsMap(splitNewItems)
      if(mapped.isEmpty) {
        prices
      } else {
        mapped
      }
    }
  }
  
  //Get the price for items that added up to a dela, if they had one.
  def priceForDeals (count: Int, products: Price): Int = {
    (count / products.numForDeal) * products.priceForDeal
  }

  //Get the price for the remaining items that didnt make a deal, if they had one.
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
          if(!products.keySet.contains(item)) {
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
  
  //Get the total!
  def total(vals: String, prod: Map[Char, Price]): Int = {
    val tot = for ((key,value) <- createToBuyMap(vals)) yield {
      // add function to check  if item is valid 
      if(useThesePrices(key).numForDeal == 0) {
        (priceWhenItemHasNoDealValues(value, prod(key)))
      } else {
        priceForDeals(value, useThesePrices(key)) + priceForNoDeals(value, prod(key))
      }
    }
    tot.sum
  }
  
   
}