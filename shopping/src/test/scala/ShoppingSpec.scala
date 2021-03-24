import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import Main._

class ShoppingSpec extends AnyFlatSpec with Matchers {
    
    case class Price (price: Int, numForDeal: Int, priceForDeal: Int)
    
    val prices = Map('a' -> Price(50, 3, 130), 
                     'b' -> Price(30, 2, 45), 
                     'c' -> Price(20, 0, 0), 
                     'd' -> Price(15, 0, 0))

    behavior of "prices"   

    it should "get the price for 'a'" in {
        prices('a').price shouldBe 50
    }           

    it should "get the numForDeal for 'a' " in {
        prices('a').numForDeal shouldBe 3
    }

    it should "get the priceForDeal for 'a' " in {
        prices('a').priceForDeal shouldBe 130
    }
    
    
    def priceForDeals (count: Int, things: Price): Int = {
      (count / things.numForDeal) * things.priceForDeal
    }

    behavior of "priceForDeals"

    
    it should "return the price for the deal" in {
        priceForDeals(3, prices('a')) shouldBe 130
        priceForDeals(4, prices('a')) shouldBe 130
        priceForDeals(5, prices('a')) shouldBe 130
    }

    it should "not return the price for the deal" in {
        priceForDeals(6, prices('a')) should not be 130
    }

    
    def checkItemIsValid (item: Char): Boolean = {
        prices.keySet.contains(item)
    }

    behavior of "checkItemIsValid"

    it should "return true" in {
        checkItemIsValid('a') shouldBe true
    }

    it should "return false" in {
        checkItemIsValid('x') shouldBe false
    }
}