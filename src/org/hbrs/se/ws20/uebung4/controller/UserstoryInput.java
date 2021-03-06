package org.hbrs.se.ws20.uebung4.controller;

import java.util.Scanner;

import org.hbrs.se.ws20.uebung4.Container;
import org.hbrs.se.ws20.uebung4.model.ContainerException;
import org.hbrs.se.ws20.uebung4.model.ContainerUtilities;
import org.hbrs.se.ws20.uebung4.model.PersistanceController;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategy;
import org.hbrs.se.ws20.uebung4.model.Userstory;
import org.hbrs.se.ws20.uebung4.view.ContainerView;

public class UserstoryInput
{
   //***
   Scanner sc = new Scanner(System.in);

   private static UserstoryInput usi = null;

   public static synchronized UserstoryInput getUserstoryInputinstance()
   {
      if (usi==null)
      {
         usi = new UserstoryInput();
      }
      return usi;
   }

   public void start()
   {
      boolean end = false;


      System.out.println("Userstory-Anwendung von mpagan2s und sbulut2s | Version 0.1");
      while (!end)
      {
         String input = sc.next();

         if (input.equals("enter"))
         {
            enterStory();
         }

         else if (input.equals("store"))
         {
            PersistanceController.store();
         }

         else if (input.equals("load"))
         {
            System.out.println("Geben Sie 'merge', 'force' oder sonstiges fuer normalen load an");
            input = sc.next();
            if (input.equals("merge"))
            {
               PersistanceController.merge();
            }

            else if (input.equals("force"))
            {
               PersistanceController.force();
            }

            else
            {
               PersistanceController.load();
            }
         }

         else if (input.equals("dump"))
         {
            ContainerView.dump();
         }

         else if (input.equals("exit"))
         {
            end = true;
         }

         else if (input.equals("help") || input.equals("?"))
         {
            System.out.println("Alle vefuegbaren Befehle");
            System.out.println("enter -> Eingabe einer User Story");
            System.out.println("store -> Abspeichern der Stories");
            System.out.println("load -> Laden von User Stories");
            System.out.println("load -> Laden von User Stories");
            System.out.println("load -> Laden von User Stories");
            System.out.println("dump -> Sortiere Ausgabe der User Stories");
            System.out.println("exit -> Anwendung verlassen");
            System.out.println("help -> Anzeige aller Befehle");
         }

         else
         {
            System.out.println("Ungueltige Eingabe, geben Sie 'help' zur Anzeige aller Befehle an.");
         }
      }
   }

   private void enterStory()
   {
      Userstory us = new Userstory();

      System.out.println("Bitte geben Sie nacheinander die geforderten Daten ein:");
      enterID(us);
      enterBeschreibung(us);
      enterAkzeptanzkriterien(us);

      System.out.println("\nBitte geben Sie nun den Mehrwert in einem Integer>0 an");
      us.setMehrwert(integerPruefung());
      System.out.println("\nBitte geben Sie nun die Strafe in einem Integer>0 an");
      us.setStrafe(integerPruefung());
      System.out.println("\nBitte geben Sie nun den Aufwand in einem Integer>0 an");
      us.setAufwand(integerPruefung());
      System.out.println("\nBitte geben Sie nun das Risiko in einem Integer>0 an");
      us.setRisiko(integerPruefung());
      us.setPrio(us.berechnePrio());
      System.out.println("Aus den Werten hat sich die Priorisierung: "+us.getPrio()+" berechnet.");
      System.out.println("Sie haben folgende Userstory angelegt:");
      System.out.println(us.toString());
      System.out.println("---------------------------------------------");
      try
      {
         Container.getContainerinstance().addUserstory(us);
      }
      catch(ContainerException e)
      {
         e.printStackTrace();
      }
   }

   private void enterID (Userstory us)
   {
      boolean invalid = true;
      System.out.println("ID-Nummer der Story (freie Auswahl durch Zahl>0, 0 für automatische Zuweisung):");
      while (invalid)
      {
         int auswahl=0;
         try
         {
            auswahl = sc.nextInt();
         }
         catch(Exception e)
         {
            System.out.println("Sie haben einen ungueltigen Wert eingegeben, nun wird eine autoamtische ZUweisung stattfinden");
         }
         if (auswahl>0)
         {
            if (ContainerUtilities.idExist(auswahl))
            {
               System.out.println("ID bereits vergeben, bitte waehlen Sie eine andere Nummer");
            }
            else
            {
               us.setId(auswahl);
               invalid = false;
            }
         }
         else if (auswahl==0)
         {
            us.setId();//Methode die die nächste freie ID sucht und vergibt
            System.out.println("Es wurde die ID "+us.getId()+" zugewiesen.");
            invalid = false;
         }
         else
         {
            System.out.println("Der Wert "+auswahl+" ist ungueltig");
         }
      }
   }

   private void enterBeschreibung(Userstory us)
   {
      System.out.println("\nGeben Sie nun die Beschreibung der Userstory an.");
      System.out.println("Dies geht über mehrere Zeilen. # markiert das Ende");
      us.setBeschreibung(langerText("#"));
   }

   private void enterAkzeptanzkriterien(Userstory us)
   {
      System.out.println("\nGeben Sie die Akzeptanzkriterien der Userstory an.");
      System.out.println("Dies geht über mehrere Zeilen. # markiert das Ende");
      us.setAkzeptanzKriterien(langerText("#"));
   }

   private String langerText(String stop)
   {
      String s = "";
      boolean vollstaendig = false;
      while (!vollstaendig)
      {
         String eingabe = sc.nextLine();
         if (eingabe.contains(stop))
         {
            int indexStop = eingabe.indexOf(stop);
            s+= eingabe.substring(0,indexStop)+"\n";
            vollstaendig = true;
         }
         else
         {
            s+= eingabe+"\n";
         }
      }
      if (s.length()==0)
      {
         return "";
      }
      s = s.substring(0,s.length()-1);
      return s;
   }

   private int integerPruefung()//muss umgesetzt werden
   {
      int number = 0;
      boolean positiv = false;

      while (!positiv)
      {
         number = sc.nextInt();
         if (number>0)
         {
            positiv = true;
         }
         else
         {
            System.out.println("Ungueltiger Wert. Probieren Sie es erneut");
         }
      }
      return number;
   }

}
