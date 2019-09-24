
package bobsrockets
package navigation {

  private[bobsrockets] class Navigator { // toti de SUB sau DIN pachetul indicat VAD inca. din afara lui, nu
    protected def useStarChart() = { }
    class LegOfJourney { // class nested de instanta
      private[Navigator] val distance = 100 // e vizibila in sus pana la (inclusiv) Navigator
    }
    private[this] var speed = 200 // e vizibil DOAR din instanta curenta, e mai restrictiv ca "private"

    def egal(n:Navigator) ={
//      n.speed nu merge
    }
  }
  class AltaDinAcelasiPachet {
    // (new Navigator).useStarChart // spre deosebire de Java, protected NU e visibil din acelasi pachet
  }
}
package launch { // este de fapt bobsrockets.launch
  object Vehicle {
    import bobsrockets.navigation._
    val guide = new Navigator
    def m():Unit = {
      new Navigator
    }
  }
}
class ClasaDirectInBobsRockets {
  new navigation.Navigator
}




object Chapter13_Visibility {

}


// javra : class X { class Y {}}
class X {
  class Y
}
// javra : class X1 { static class Y1 {}}
object X1 {
  class Y1
}