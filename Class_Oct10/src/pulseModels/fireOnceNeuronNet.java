/*
**      Neural Net of fire once neurons solves the shortest time problem
**      Coupled Model of PulseGenerator & FireOnce Neuron
**                                  Huoping Chen,
**                                  09/08/2002
*/
package pulseModels;

import simView.*;
import genDevs.plots.*;
import java.awt.*;
import java.lang.*;
import genDevs.modeling.*;
import genDevs.simulation.*;
import GenCol.*;
import java.util.*;

public class fireOnceNeuronNet extends  ViewableDigraph{

/* fire delay variables */
double f1_firedelay, f2_firedelay,f3_firedelay,f4_firedelay;

public fireOnceNeuronNet(){
super("fireOnceNeuronNet");

addInport("in");
addOutport("out");


/* New a pulseGenr object */
ViewableAtomic pg = new pulseGenr("pg",100);
add(pg);

// Case1: Neuron 2 has the shortest path
// 10+10 > 20
/*
f1_firedelay = 10;
f2_firedelay = 10;
f3_firedelay = 10;
f4_firedelay = 10;
*/

// Case2: Neuron 1+3 has the shortest path
// 4+2 < 10
f1_firedelay = 4;
f2_firedelay = 2;
f3_firedelay = 20;
f4_firedelay = 10;


/* New Fireonce Neuron object 1 */
ViewableAtomic fon1 = new fireOnceNeuron("fireonce-neuron1",f1_firedelay);
add(fon1);

/* New Fireonce Neuron object 2 */
ViewableAtomic fon2 = new fireOnceNeuron("fireonce-neuron2",f2_firedelay);
add(fon2);

/* New Fireonce Neuron object 3 */
ViewableAtomic fon3 = new fireOnceNeuron("fireonce-neuron3",f3_firedelay);
add(fon3);

/* New Fireonce Neuron object 4 */
ViewableAtomic fon4 = new fireOnceNeuron("fireonce-neuron4",f4_firedelay);
add(fon4);

/*
** pg:   output ---> fon1:input
** pg:   output ---> fon3:input
** fon1: output ---> fon2:input
** fon2: output ---> fon4:input
** fon3: output ---> fon4:input
*/
addCoupling(pg,"out",fon1,"in");
addCoupling(pg,"out",fon3,"in");
addCoupling(fon1,"out",fon2,"in");
addCoupling(fon2,"out",fon4,"in");
addCoupling(fon3,"out",fon4,"in");

addCoupling(fon4,"out",this,"out");
}

    /**
     * Automatically generated by the SimView program.
     * Do not edit this manually, as such changes will get overwritten.
     */
    public void layoutForSimView()
    {
        preferredSize = new Dimension(721, 379);
        if((ViewableComponent)withName("fireonce-neuron1")!=null)
             ((ViewableComponent)withName("fireonce-neuron1")).setPreferredLocation(new Point(185, 57));
        if((ViewableComponent)withName("fireonce-neuron2")!=null)
             ((ViewableComponent)withName("fireonce-neuron2")).setPreferredLocation(new Point(352, 66));
        if((ViewableComponent)withName("pg")!=null)
             ((ViewableComponent)withName("pg")).setPreferredLocation(new Point(-28, 150));
        if((ViewableComponent)withName("fireonce-neuron4")!=null)
             ((ViewableComponent)withName("fireonce-neuron4")).setPreferredLocation(new Point(475, 170));
        if((ViewableComponent)withName("fireonce-neuron3")!=null)
             ((ViewableComponent)withName("fireonce-neuron3")).setPreferredLocation(new Point(276, 248));
    }
}
