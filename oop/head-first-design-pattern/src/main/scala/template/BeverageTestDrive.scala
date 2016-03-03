package template

/**
  * Created by michael on 2/24/16.
  */
object BeverageTestDrive {
  def main1(args: Array[String]) = {
    val tea = new Tea
    val coffee = new Coffee

    println("\nMaking tea...")
    tea.prepareRecipe()

    println("\nMaking coffee...")
    coffee.prepareRecipe()
  }
}
