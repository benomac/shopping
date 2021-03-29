import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Main._
import Yoots._

class ShoppingSpec extends AnyFlatSpec with Matchers {
    
    // case class Price (price: Int, numForDeal: Int, priceForDeal: Int)
    
    val costs = Map('a' -> Price(50, 3, 130), 
                     'b' -> Price(30, 2, 45), 
                     'c' -> Price(20, 0, 0), 
                     'd' -> Price(15, 0, 0))
    
    
    behavior of "priceForDeals"

    it should "return the cost for items that made the deal quantity" in {
        priceForDeals(3, costs('a')) shouldBe 130
    }


    behavior of "priceForNoDeals" 

    it should "return the cost of remainder items that didn't make the deal quantity" in {
        priceForNoDeals(4, costs('a')) shouldBe 50
    }

    
    behavior of "priceWhenItemHasNoDealValues" 

    it should "return the price for a number of items that have no deal values" in {
        priceWhenItemHasNoDealValues(3, costs('c')) shouldBe 60
    }

    
    behavior of "removeInvalidItems" 

    it should "return a string only of item in the costs map" in {
        removeInvalidItems("aaajckla", costs) shouldBe "aaaca"
    }

    //Is this test necessary?
    it should "not blow up if an item is invalid" in {
        removeInvalidItems("j", costs) shouldBe "" 
    }

    
    behavior of "createToBuyMap" 

    it should "return a map of key: items, value: number of itmes" in {
        createToBuyMap("aabbccaabb") shouldBe Map('a' -> 4, 'b' -> 4, 'c' -> 2)
    }


    behavior of "total" 

    it should "return the total cost of the items 'aacba'" in {
        total("aacba", costs) shouldBe 180
    }

    // behavior of "updatePriceMap" 

    // it should
       

   
}