package org.hbrs.se.ws20.uebung4.model;

public class Userstory
{
   private int id;
   private String beschreibung;
   private String akzeptanzKriterien;
   //Gloger Kriterien
   private int mehrwert;
   private int strafe;
   private int aufwand;
   private int risiko;
   private double prio;

   public Userstory()
   {

   }

   Userstory(int id, String beschreibung, String akzeptanzKriterien,
             int mehrwert, int strafe, int aufwand, int risiko)
   {
      setId(id);
      setBeschreibung(beschreibung);
      setAkzeptanzKriterien(akzeptanzKriterien);
      setMehrwert(mehrwert);
      setStrafe(strafe);
      setAufwand(aufwand);
      setRisiko(risiko);
      setPrio(berechnePrio());
   }

   public double berechnePrio()
   {
      return (mehrwert+strafe) / (aufwand+risiko);
   }

   @Override
   public String toString()
   {
      String s = "";
      s+= getId()+" | ";
      s+= getBeschreibung()+" | ";
      s+= getAkzeptanzKriterien()+" | ";
      s+= getMehrwert()+" | ";
      s+= getStrafe()+" | ";
      s+= getAufwand()+" | ";
      s+= getRisiko()+" | ";
      s+= getPrio();
      return s;
   }

   //get Methoden
   public int getId()
   {
      return id;
   }

   public String getBeschreibung()
   {
      return beschreibung;
   }

   public String getAkzeptanzKriterien()
   {
      return akzeptanzKriterien;
   }

   public double getPrio()
   {
      return prio;
   }

   public int getAufwand()
   {
      return aufwand;
   }

   public int getMehrwert()
   {
      return mehrwert;
   }

   public int getRisiko()
   {
      return risiko;
   }

   public int getStrafe()
   {
      return strafe;
   }

   //set Methoden
   public void setId(int id)
   {
      this.id = id;
   }
   //fuer automatische Zuweisung einer ID
   public void setId()
   {
      int i = 1;
      boolean freieID = false;
      while (!freieID)
      {
         if (ContainerUtilities.idExist(i))
         {
            //ID bereits vergeben
            i++;
         }
         else
         {
            freieID = true;
            setId(i);
         }
      }
   }

   public void setBeschreibung(String beschreibung)
   {
      this.beschreibung = beschreibung;
   }

   public void setAkzeptanzKriterien(String akzeptanzKriterien)
   {
      this.akzeptanzKriterien = akzeptanzKriterien;
   }

   public void setPrio(double prio)
   {
      this.prio = prio;
   }

   public void setAufwand(int aufwand)
   {
      if (aufwand<1)
      {
         throw new IllegalArgumentException("Ungueltige Eingabe");
      }
      this.aufwand = aufwand;
   }

   public void setMehrwert(int mehrwert)
   {
      if (mehrwert<1)
      {
         throw new IllegalArgumentException("Ungueltige Eingabe");
      }
      this.mehrwert = mehrwert;
   }

   public void setRisiko(int risiko)
   {
      if (risiko<1)
      {
         throw new IllegalArgumentException("Ungueltige Eingabe");
      }
      this.risiko = risiko;
   }

   public void setStrafe(int strafe)
   {
      if (strafe<1)
      {
         throw new IllegalArgumentException("Ungueltige Eingabe");
      }
      this.strafe = strafe;
   }
}
