import Yoots._

object Main extends App {

  println(prices)
  
  
  
  prices = updatePriceMap(prices, 'a', 10, 2, 15)
  prices = updatePriceMap(prices, 'g', 30, 2, 50)
  prices = updatePriceMap(prices, 'h', 40, 2, 70)
  
  println(prices)
  
  //Get the items to be bought.
  val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")

  
  //create a new string of valid items only, 
  //and print error message for invalid items.
  val valid = removeInvalidItems(items, prices)
  
  //Print the calculated total cost.   
  println("Total " + total(valid, prices))


};