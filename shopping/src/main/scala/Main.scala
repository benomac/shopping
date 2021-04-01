import Yoots._
import scala.collection.mutable.ArrayBuffer
object Main extends App {
  

  //Choose which price Map to use
  val useThesePrices = decideWhichMapToUse(args)
 
  //Get the items to be bought.
  val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")

  //create a new string of valid items only, 
  //and print error message for invalid items.
  val valid = removeInvalidItems(items, useThesePrices)

  //Print the calculated total cost.   
  println("Total " + total(valid, useThesePrices))


};