package bobsrockets
package navigation {
  private[bobsrockets] class Navigator { // toti de SUB sau DIN pachetul indicat VAD inca
    (new LegOfJourney).distance
    protected def useStarChart() = { }
    class LegOfJourney { // class nested de instanta
      private[Navigator] val distance = 100 // e vizibila in sus pana la (inclusiv) Navigator
    }
    private[this] var speed = 200 // e vizibil DOAR din instanta curenta
  }
  class AltaDinAcelasiPachet {
    // (new Navigator).useStarChart // spre deosebire de Java, protected NU e visibil din acelasi pachet
  }
}
package launch { // este de fapt bobsrockets.launch
  import bobsrockets.navigation._
  object Vehicle {
    val guide = new Navigator
  }
}
class ClasaDirectInBobsRockets {
  new navigation.Navigator
}




object Chapter13_Visibility {

}
