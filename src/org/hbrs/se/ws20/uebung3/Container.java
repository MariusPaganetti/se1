package org.hbrs.se.ws20.uebung3;
import java.io.Serializable;
import java.util.ArrayList;

public class Container implements Serializable
{
   private int zaehlerID = 0;
   private static final Container con = new Container();
   private ArrayList<Member> memberList =  new ArrayList<Member>();

    /**
    * interne Klasse Member zur Kapselung der Funktionen
    */
   public class Member implements org.hbrs.se.ws20.uebung3.Member, Serializable
   {
      final private int id;
      //eigener interner Zaehler zur Vermeidung von doppelten IDs
      public Member()
      {
         id = zaehlerID++;
      }
      //Konstruktur mit Option eigene ID-Nummer zu vergeben
      public Member(int id)
      {
         this.id = id;
      }

      @Override
      public Integer getID()
      {
         return this.id;
      }

      public String toString()
      {
         return "Member (ID = "+getID()+" )";
      }


   }

   /**
    * weitere Klasse fuer ContainerException
    */
   public class ContainerException extends Exception
   {
      public ContainerException()
      {
         super("Fehler im Container");
      }

      public ContainerException(String output)
      {
         super(output);
      }

      public ContainerException(int id)
      {
         super("Das Member-Objekt mit der ID "+id+" ist bereits vorhanden!");
      }
   }


   //Konstruktor
   public Container()
   {

   }

   /**
    *ausgelagerte Funktion fuer deleteMember
    */
   private Member getMember(int id) throws ContainerException
   {
      for (int i = 0; i<memberList.size(); i++)
      {
         if (memberList.get(i).getID() == id)
         {
            return memberList.get(i);
         }
      }
      return null;
   }

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

   public void addMember(Member member) throws ContainerException
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
      return memberList.size();
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
      memberList.clear();
   }

   public ArrayList<Member> getCurrentList()
   {
      return memberList;
   }

   public void store()
   {
      PersistenceStrategyStream<Member> pss = new PersistenceStrategyStream<>();
      try
      {
         pss.save(memberList);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }

   public void load()
   {
      PersistenceStrategy<Member> ps = new PersistenceStrategyStream<>();
      try
      {
         memberList = (ArrayList<Member>) ps.load();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}
