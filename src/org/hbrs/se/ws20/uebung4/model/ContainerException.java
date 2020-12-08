package org.hbrs.se.ws20.uebung4.model;

import org.hbrs.se.ws20.uebung4.Container;

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
