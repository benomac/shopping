import Yoots._

object Main extends App {

  //Get the items to be bought
  val items = scala.io.StdIn.readLine("Enter items list eg: abcd :-")

  //create a new string of valid items only.
  val valid = removeInvalidItems(items, prices)
  
  //Get the total cost   
  println("Total " + total(valid, prices))


};