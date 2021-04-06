import Yoots._

object Main extends App {
  
  val useThesePrices = decideWhichMapToUse(args)
  
  val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")

  val valid = removeInvalidItems(items, useThesePrices)

  println("Total " + total(valid, useThesePrices))

}