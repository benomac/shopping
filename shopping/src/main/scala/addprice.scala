// ADD THIS TO MAKE THE PRICES interactice


// this is to take input of new items
//     //Ask for details of new item
//     var new_item = scala.io.StdIn.readLine("Enter the details of the item, separated by commas: name, price(in pence), amount for deal, deal price(in pence) ")
    
//     //Set yes to "yes"
//     var yes = "yes"

//     //Create a map tp hold key item name, value array of item price details
//     var prices=scala.collection.mutable.Map[String, Array[String]]()

//     while(yes == "yes") {
        
//         //Creaet array of new_item
//         var items_list = new_item.split(",")
        
//         //Add key value to map
//         prices += (items_list(0) -> items_list.slice(1, 3))
        
//         //Prompt for next item
//         yes = scala.io.StdIn.readLine("Add another item(y/n)?")
        
//         //get next item details, if there is one
//         if(yes == "yes") {
//             new_item = scala.io.StdIn.readLine("Enter the details of the item, separated by commas: name, price(in pence), amount for deal, deal price(in pence) ")
//         } else {
//             //Exit while loop, by setting yes to "no"
//             yes = "no"
//         }
//     }