package org.hbrs.se.ws20.uebung4.view;

import java.util.ArrayList;
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

   public static void tabelle()
   {
      String s;
      System.out.println("Userstory |\t id\t beschreibung\t Akzeptanzkriterien\t Mehrwert\t Strafe\t Aufwand\t Risiko\t Prio");
      ArrayList<Userstory> usList =  getContainerinstance().getCurrentList();
      for (int i=0; i<usList.size(); i++){
         Userstory temp = usList.get(i);
         s=""+i+"\t|\t ";
         s+=temp.getId()+"\t ";
         s+=temp.getBeschreibung()+"\t ";
         s+=temp.getAkzeptanzKriterien()+"\t ";
         s+=temp.getMehrwert()+"\t ";
         s+=temp.getStrafe()+"\t ";
         s+=temp.getAufwand()+"\t ";
         s+=temp.getRisiko()+"\t ";
         s+=temp.getPrio()+"\t";

         System.out.println(s);
      }
   }
}
