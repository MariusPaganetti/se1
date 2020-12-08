package org.hbrs.se.ws20.uebung4.view;

import java.util.stream.Stream;
import org.hbrs.se.ws20.uebung4.Container;
import org.hbrs.se.ws20.uebung4.model.Userstory;

public class ContainerView extends Container
{
   public static void dump()
   {
      System.out.println("dump");
      //Stream.of(getContainerinstance().getCurrentList().)
      //getContainerinstance().getCurrentList().stream().sorted(Userstory us1, Userstory us2) -> Double.compare(us1)


      getContainerinstance().getCurrentList().stream().filter( userStory -> userStory.getAufwand() > 4  )   // Filter
            .filter( userStory -> userStory.getPrio() < 2.0 )
            .sorted(  (us1, us2)  -> Double.compare( us1.getPrio() , us2.getPrio() ) ) // MAP
            .forEach( userStory -> System.out.println( userStory.toString() ) ); // Reduce
   }
}
