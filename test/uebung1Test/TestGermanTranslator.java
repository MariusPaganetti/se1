package uebung1Test;

import org.hbrs.se.ws20.uebung1.control.GermanTranslator;
import org.hbrs.se.ws20.uebung1.control.factory.Factory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestGermanTranslator
{

   @Test
   public void testIntergerValues()
   {
      GermanTranslator gT = Factory.createGermanTranslator();
      assertEquals("fuenf",gT.translateNumber(5),"gueltigeer Wert wird nicht uebersetzt");/** Zahl im gueltigen Bereich testen */
      assertEquals(("Uebersetzng der Zahl -1 nicht moeglich (1.0)"),gT.translateNumber(-1));/** Zahl im ungueltigen negativen Bereich testen */
      assertEquals(("Uebersetzng der Zahl 11 nicht moeglich (1.0)"),gT.translateNumber(11));/** Zahl im ungueltiegen oberen Bereich testen */
      assertEquals(("Uebersetzng der Zahl 0 nicht moeglich (1.0)"),gT.translateNumber(0));/** Spezialfall 0 testen */
   }
}
