package org.hbrs.se.ws20.uebung4;
import java.io.Serializable;
import java.util.ArrayList;

import org.hbrs.se.ws20.uebung4.model.ContainerException;
import org.hbrs.se.ws20.uebung4.model.ContainerUtilities;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategy;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategyStream;
import org.hbrs.se.ws20.uebung4.model.Userstory;

public class Container
{
   private int zaehlerID = 0;
   private static Container con = null;
   private ArrayList<Userstory> usList =  new ArrayList<Userstory>();

   public static synchronized Container getContainerinstance()
   {
      if (con==null)
      {
         con = new Container();
      }
      return con;
   }

   public String deleteStory(int id) throws ContainerException
   {
      String output =""; //temp speichern der Member ID
      try
      {
         Userstory memberToRemove = ContainerUtilities.getStory(id);
         output = memberToRemove.toString();
         usList.remove(memberToRemove);
      }
      catch(Exception e)
      {
         return "Kein Member mit der ID: "+id+" vorhanden";
      }
      return output+" geloescht";
   }

   public void addUserstory(Userstory us) throws ContainerException
   {
      if(!ContainerUtilities.storyExist(us) && us!=null && !ContainerUtilities.idExist(us.getId()))
      {
         usList.add(us);
      }
      else
      {
         try
         {
            throw new ContainerException(us.getId());
         }
         catch(Exception e)//wegen null PointerException bei leerem add
         {
            throw new ContainerException("Member mit Nullpointer wird nicht akzeptiert");
         }
      }
   }

   public int size()
   {
      return usList.size();
   }

   public void resetArray()
   {
      usList.clear();
   }

   public ArrayList<Userstory> getCurrentList()
   {
      return usList;
   }

   public void storePss()
   {
      PersistenceStrategyStream<Userstory> pss = new PersistenceStrategyStream<>();
      try
      {
         pss.save(usList);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void loadPss()
   {
      PersistenceStrategy<Userstory> ps = new PersistenceStrategyStream<>();
      try
      {
         usList = (ArrayList<Userstory>) ps.load();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void mergePss(){
      PersistenceStrategy<Userstory> ps = new PersistenceStrategyStream<>();
      try
      {
         ArrayList<Userstory> temp = (ArrayList<Userstory>) ps.load();

         for (int i=0; i<temp.size(); i++){
            if(usList.contains(temp.get(i))){
               temp.get(i).setId();
            }
            usList.add(temp.get(i));
         }
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}
