//   object Main extends App {
      
//     //make case class
//     case class Price (price: Int, num_for_deal: Int, price_4_deal: Int)

//     //Map of classes
//     var prices = Map('a' -> Price(50, 3, 130), 'b' -> Price(30, 2, 45), 'c' -> Price(20, 0, 0), 'd' -> Price(15, 0, 0))

//     //Create var for items to buy
//     var items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")
    
//     //Map of things to buy
//     val tobuy =
//     (for {
//       x <- items
//       i = items.count(_ == x)
//     } yield (x -> i)).toMap
    
    
//     //Get the price for any deals made
//     def PriceForDeals (count: Int, amountForDeal: Int, priceForDeal: Int): Int = {
//       (count / amountForDeal) * priceForDeal
//     }
    
//     //Get the price for item that didnt make deal.
//     def PriceForNoDeals (count: Int, amountForDeal: Int, normalPrice: Int): Int = {
//       (count % amountForDeal) * normalPrice
//     }

//     var total = 0
//     for ((key,value) <- tobuy) {
//         if(prices(key).num_for_deal == 0) {
//           total = total + (value * prices(key).price)
//         } else {
//           total = total + PriceForDeals(value, prices(key).num_for_deal, prices(key).price_4_deal) + PriceForNoDeals(value, prices(key).num_for_deal, prices(key).price)
//         }
//       }


//     println("total " + total)
          
//   }