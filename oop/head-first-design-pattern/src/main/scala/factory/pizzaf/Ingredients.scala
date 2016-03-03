package factory.pizzaf

/**
  * Created by michael on 2/23/16.
  */
trait Dough
class ThinCrustDough extends Dough
class ThickCrustDough extends Dough

trait Sauce
class MarinaraSauce extends Sauce
class PlumTomatoSauce extends Sauce

trait Cheese
class ReggianoCheese extends Cheese
class MozzarellaChees extends Cheese

trait Veggies
class Garlic extends Veggies
class Onion extends Veggies
class Mushroom extends Veggies
class RedPepper extends Veggies
class BlackOlives extends Veggies
class EggPlant extends Veggies
class Spinach extends Veggies

trait Pepperoni
class SlicedPepperoni extends Pepperoni

trait Clams
class FreshClams extends Clams
class FrozenClams extends Clams

