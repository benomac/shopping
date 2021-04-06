import Main._

object Yoots {
    
  case class Price (price: Int, numForDeal: Int, priceForDeal: Int)
  
  val prices = Map('a' -> Price(50, 3, 130), 
                    'b' -> Price(30, 2, 45), 
                    'c' -> Price(20, 0, 0), 
                    'd' -> Price(15, 0, 0))

  def priceForDeals (count: Int, products: Price): Int = {
    (count / products.numForDeal) * products.priceForDeal
  }

  def priceForNoDeals (count: Int, products: Price): Int = {
    (count % products.numForDeal) * products.price
  }

  def priceWhenItemHasNoDealValues (count: Int, products: Price): Int = {
    count * products.price
  }

  def removeInvalidItems (items: String, products: Map[Char, Price]): String = {
      val valid = for (item <- items) yield {
          if(!products.keySet.contains(item)) {
              println(item  + " is an invalid item")
              ""
          } else {
              item
          }
      }
      valid.mkString("")
  }

  def createToBuyMap (items: String): Map[Char, Int] = {
      (for {
      x <- items
      i = items.count(_ == x) 
      } yield (x -> i)).toMap
    } 
  
  def total(vals: String, prod: Map[Char, Price]): Int = {
    val tot = for ((key,value) <- createToBuyMap(vals)) yield {
      if(prod(key).numForDeal == 0) {
        (priceWhenItemHasNoDealValues(value, prod(key)))
      } else {
        priceForDeals(value, prod(key)) + priceForNoDeals(value, prod(key))
      }
    }
    tot.sum
  }

  def getArgsAndSplit(args: Array[String]): Array[String] = {
    val newItems = args(0).split(",")
    newItems
  }

  def getSplitArgsAndSplitAgain(splitArgs: Array[String]):  Array[Array[String]] = {
      val splitList = for (i <- splitArgs) yield {
      i.split(" ")
    }
    splitList
  }

  
  def createTheNewItemsMap(arr: Array[Array[String]]): Map[Char,Yoots.Price] = {
    val newItemsMap = for {
      i <- arr
        isValid = if (!(i.length == 4 && i(1).charAt(0).isDigit && i(2).charAt(0).isDigit && i(3).charAt(0).isDigit)) {
          println("Item " + "'" + i(0).charAt(0) + "'" + " has been entered with the incorrect format!")
          Map.empty
        } else { 
          val x = Price(i(1).toInt, i(2).toInt, i(3).toInt)
          Map(i(0)(0) -> x)
        } 
      } yield isValid
    newItemsMap.flatten.toMap
  }
    
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

  
   
}