package org.hbrs.se.ws20.uebung4.model;

import java.util.Scanner;

import org.hbrs.se.ws20.uebung4.Container;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategyStream;

public class PersistanceController
{
   static String method;
   //pss or psm

   public static void setMethod(String s)
   {
      method = s;
   }

   public static void store()
   {
      if (method=="pss")
      {
         Container.getContainerinstance().storePss();
      }
      else //
      {
         //Container.getInstance().storePsm();
      }
   }

   public static void load()
   {
      System.out.println("Wollen Sie die aktuellen Daten ueberschreiben oder mergen?");
      System.out.println("Druecken sie 'u' für das ueberschreiben und 'm' fuer mergen");

      Scanner sc = new Scanner(System.in);
      char c = sc.next().charAt(0);
      if (c=='u')
      {
         force();
      }
      else if (c=='m')
      {
         merge();
      }
      else
      {
         System.out.println("Ungueltige Eingabe, Sie kehren nun zurueck");
      }
   }

   public static void merge()
   {
      if (method=="pss")
      {
         Container.getContainerinstance().mergePss();
      }
      else //
      {
         //Container.getInstance().mergePsm();
      }
   }

   public static void force()
   {
      if (method=="pss")
      {
         Container.getContainerinstance().loadPss();
      }
      else //
      {
         //Container.getInstance().loadPsm();
      }
   }
}
