object Main extends App {
    
  //make case class
  case class Price (price: Int, num_for_deal: Int, price_4_deal: Int)

  //Map of classes
  var prices = Map('a' -> Price(50, 3, 130), 'b' -> Price(30, 2, 45), 'c' -> Price(20, 0, 0), 'd' -> Price(15, 0, 0))

  //Create var for items to buy
  var items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")
  
  // CHANGE THIS TO BE INITIALIZED DURING DECLARATION

  val tobuy =
  (for {
    x <- items
    i = items.count(_ == x)
  } yield (x -> i)).toMap

  var total: Int = 0
  
  def spesh (count: Int, normal_price: Int,  am_for_deal: Int, price_for_deal: Int) : Int = {
      
      val num_of_deals = count / am_for_deal

      val no_deals = count % am_for_deal

      val price_for_no_deals = no_deals * normal_price

      val price_for_deals = num_of_deals * price_for_deal

      val tot = price_for_deals + price_for_no_deals

      tot

  }

  for ((key,value) <- tobuy) {
      if(prices(key).num_for_deal == 0) {
        total = total + (value * prices(key).price)
      } else {
        var tot = spesh(value, prices(key).price, prices(key).num_for_deal, prices(key).price_4_deal)
      total = total + tot
      }
    }


  println("total " + total)
        
}