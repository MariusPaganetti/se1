package org.hbrs.se.ws20.uebung2;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Container
{

    /**
    * interne Klasse Member zur Kapselung der Funktionen
    */
   public class Member implements org.hbrs.se.ws20.uebung2.Member
   {
      final private int id;
      private int zaehlerID = 0;

      public Member()
      {
         id = zaehlerID++;
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
         super("Fehler in Container");
      }

      public ContainerException(String output)
      {
         super(output);
      }
   }


   private ArrayList<Member> memberList =  new ArrayList<Member>();

   //Konstruktor
   public Container()
   {

   }

   /**
    *ausgelagerte Funktion fuer deleteMember
    */
   private Member getMember(int id)
   {
      for (int i = 0; i<memberList.size(); i++)
      {
         if (memberList.get(i).getID() == id)
         {
            return memberList.get(i);
         }
      }
      throw new NoSuchElementException("Kein Member mit der ID: "+id+" vorhanden");
   }

   public String deleteMember(int id)
   {
      String output =""; //temp speichern der Member ID
      try
      {
         Member memberToRemove = getMember(id);
         output = memberToRemove.toString();
         memberList.remove(memberToRemove);
      }
      catch(NoSuchElementException e)
      {
         return "Kein Member mit der ID: "+id+" vorhanden";
      }
      return output+" geloescht";
   }

   public void addMember(Member member) throws ContainerException
   {
      if (member!=null)
      {
         memberList.add(member);
      }
      else
      {
         throw new ContainerException("ungueltige Eingabe");
      }
   }

   public void dump()
   {
      String output = "";
      for (int i = 0; i<memberList.size(); i++)
      {
         output+=memberList.get(i).toString()+"\n";
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





}
