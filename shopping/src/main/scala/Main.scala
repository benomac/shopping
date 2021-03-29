import Yoots._

object Main extends App {

  //Prrint original prices Map.
  println(prices)
  
  prices = updatePriceMap(prices, 'a', 10, 2, 15)
  
  
  //Print updated prices Map.
  println(prices)
  
  //Get the items to be bought.
  val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")

  
  //create a new string of valid items only, 
  //and print error message for invalid items.
  val valid = removeInvalidItems(items, prices)
  
  //Print the calculated total cost.   
  println("Total " + total(valid, prices))


};