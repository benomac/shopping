import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Main._

class ShoppingSpec extends AnyFlatSpec with Matchers {
    
    // case class Price (price: Int, numForDeal: Int, priceForDeal: Int)
    
    val costs = Map('a' -> Price(50, 3, 130), 
                     'b' -> Price(30, 2, 45), 
                     'c' -> Price(20, 0, 0), 
                     'd' -> Price(15, 0, 0))

    behavior of "costs"   

    it should "get the price for 'a'" in {
        costs('a').price shouldBe 50
    }           

    it should "get the numForDeal for 'a' " in {
        costs('a').numForDeal shouldBe 3
    }

    it should "get the priceForDeal for 'a' " in {
        costs('a').priceForDeal shouldBe 130
    }

    it should "not get the price for 'a'" in {
        costs('b').priceForDeal should not be 130
    }
    
    
    
    behavior of "priceForDeals"

    it should "return the cost for the amount of deals" in {
        priceForDeals(3, costs('a')) shouldBe 130
    }

    it should "not return the price for the deal" in {
        priceForDeals(1, costs('a')) should not be 130
    }


    behavior of "priceForNoDeals" 

    it should "return the price for left over item that didn't make the deal" in {
        priceForNoDeals(4, costs('a')) shouldBe 50
    }

    it should "not return the price for left over item that didn't make the deal" in {
        priceForNoDeals(4, costs('a')) should not be 130
    }


    behavior of "priceWhenItemHasNoDealValues" 

    it should "return the price for a number of items that have no deal values" in {
        priceWhenItemHasNoDealValues(3, costs('c')) shouldBe 60
    }

    


    behavior of "checkItemIsValid"

    it should "return true" in {
        checkItemIsValid('a', costs) shouldBe true
    }

    it should "return false" in {
        checkItemIsValid('x', costs) shouldBe false
    }

}