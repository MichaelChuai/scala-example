package facade

/**
  * Created by michael on 2/24/16.
  */
class Screen(description: String = "") {

  def up() = {
    println(description + " going up")
  }

  def down() = {
    println(description + " going down")
  }

  override def toString: String = description
  
}
