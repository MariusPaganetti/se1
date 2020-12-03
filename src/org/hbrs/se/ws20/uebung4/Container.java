package org.hbrs.se.ws20.uebung4;
import java.io.Serializable;
import java.util.ArrayList;

import org.hbrs.se.ws20.uebung4.model.Userstory;

public class Container implements Serializable
{
   private int zaehlerID = 0;
   private static Container con = new Container();
   private ArrayList<Userstory> usList =  new ArrayList<Userstory>();

   public synchronized Container getContainerinstance()
   {
      return con;
   }

   /**
    *ausgelagerte Funktion fuer deleteMember
    */
  /** private Member getMember(int id) throws ContainerException
   {
      for (int i = 0; i<memberList.size(); i++)
      {
         if (memberList.get(i).getID() == id)
         {
            return memberList.get(i);
         }
      }
      return null;
   }*/

   public String deleteMember(int id) throws ContainerException
   {
      String output =""; //temp speichern der Member ID
      try
      {
         Member memberToRemove = getMember(id);
         output = memberToRemove.toString();
         memberList.remove(memberToRemove);
      }
      catch(Exception e)
      {
         return "Kein Member mit der ID: "+id+" vorhanden";
      }
      return output+" geloescht";
   }

   public void addUserstory(Userstory us) throws ContainerException
   {
      if(!memberExist(member) && member!=null && !idExist(member.getID()))
      {
         memberList.add(member);
      }
      else
      {
         try
         {
            throw new ContainerException(member.getID());
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

   /**
    * Funktion, ob ein Member bereits in der Liste existiert
    */
   public boolean memberExist(Member member)
   {
      return memberList.contains(member);
   }
   //Funktion, ob eine ID existiert
   public boolean idExist(int id)
   {
      try
      {
         if( null != getMember(id) )
         {
            return true;
         }
         return false;
      }
      catch(Exception e)
      {
         return false;
      }
   }

   public void resetArray()
   {
      usList.clear();
   }

   public ArrayList<Userstory> getCurrentList()
   {
      return usList;
   }

   public void store()
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

   public void load()
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
}
