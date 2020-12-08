package org.hbrs.se.ws20.uebung4.controller;

import org.hbrs.se.ws20.uebung4.Container;
import org.hbrs.se.ws20.uebung4.model.PersistanceController;
import org.hbrs.se.ws20.uebung4.model.PersistenceStrategyStream;

public class Main
{
   public static void main(String[] args)
   {
      /**
       * Festlegen der Startparameter:
       * Speichertyp
       * Dateiname+ort
       */
      //pps = PersistanceStrategeStream | psm = PersistanceStrategyMongoDB
      String persistanceMethod = "pss";
      //Datei fuer Stream
      String datei = "src/org/hbrs/se/ws20/uebung4/Data_UserStories.ser";

      //Parameter uebertragen
      PersistenceStrategyStream.setDatei(datei);
      PersistanceController.setMethod(persistanceMethod);

      Container con = Container.getContainerinstance();
      UserstoryInput.getUserstoryInputinstance().start();
   }
}
