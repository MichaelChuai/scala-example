package strategy

/**
  * Created by michael on 2/22/16.
  */

object MiniDuckSimulator {
  def main1(args: Array[String]) = {
    val mallard: Duck = new MallardDuck
    mallard.performQuack()
    mallard.performFly()

    val model: Duck = new ModelDuck
    model.performFly()
    model.setFlyBehavior(new FlyRocketPowered)
    model.performFly()
  }
}
