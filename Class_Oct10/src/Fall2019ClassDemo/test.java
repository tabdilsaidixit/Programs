package Fall2019ClassDemo;


import GenCol.*;
import genDevs.modeling.*;
import genDevs.simulation.*;
import genDevs.simulation.realTime.*;


public class test{

protected static digraph testDig;

  public test(){}

  public static void main(String[ ] args)
  {
      testDig = new CarWashSys();
      coordinator cs = new coordinator(testDig);

//      TunableCoordinator cs = new TunableCoordinator(testDig);
//      cs.setTimeScale(0.1);

      cs.initialize();
      cs.simulate(50000);
  }
}
