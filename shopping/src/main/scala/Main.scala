object Main extends App {
    
  //make case class
  val prices = Map('a' -> Array(50, 3, 130), 'b' -> Array(30, 2, 45), 'c' -> Array(20, 0, 0), 'd' -> Array(15, 0, 0))

  

  //Create var for items to buy
  var items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")
  
  
  var tobuy:Map[Char,Int] = Map()
  
  for(x <- items ){
    var i = items.count(_ == x)
    tobuy += (x -> i)
  } 
  
  var total: Int = 0
  
  def spesh (count: Int, normal_price: Int,  am_for_deal: Int, price_for_deal: Int) : Int = {
      
      val num_of_deals = count / am_for_deal

      var no_deals = count % am_for_deal

      var price_for_no_deals = no_deals * normal_price

      var price_for_deals = num_of_deals * price_for_deal

      var tot = price_for_deals + price_for_no_deals

      tot

  }

  for ((key,value) <- tobuy) {
      if(prices(key)(1) == 0) {
        total = total + (value * prices(key)(0))
      } else {
        var tot = spesh(value, prices(key)(0), prices(key)(1), prices(key)(2))
      total = total + tot
      }
    }


  println("total " + total)
        
        
            

    

    
    
}