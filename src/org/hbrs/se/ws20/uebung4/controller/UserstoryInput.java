package org.hbrs.se.ws20.uebung4.controller;

import java.util.Scanner;
import org.hbrs.se.ws20.uebung4.view.ContainerView;

public class UserstoryInput
{
   Scanner sc = new Scanner(System.in);

   public void start()
   {
      boolean end = false;

      System.out.println("Userstory-Anwendung von mpagan2s | Version 0.1");
      while (!end)
      {
         String input = sc.next();

         if (input=="enter")
         {
            enterStory();
         }

         else if (input=="store")
         {

         }

         else if (input=="load")
         {
            input = sc.next();
            if (input=="merge")
            {

            }

            else if (input=="force")
            {

            }

            else
            {
               //was passiert hierbei?
            }
         }

         else if (input=="dump")
         {
            ContainerView.dump();
         }

         else if (input=="exit")
         {
            end = true;
         }

         else if (input=="help" || input=="?")
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

   }

}
