package uebung1Test;

import org.hbrs.se.ws20.uebung1.view.*;
import org.junit.jupiter.api.Test;


import java.sql.ClientInfoStatus;

public class TestClient
{
   @Test /**@Test lediglich zur Deklaration als Testklasse, Ueberpruefung muss immer noch haendisch durchgefuehrt werden */
   public void testClient()
   {
      Client client = new Client();
      client.display(5); /** Display muss sich mit dem String "Das Ergebnis der Berechnung: fuenf" oeffnen,
    * anschließend schließen */
    }
   /**
    * Vorteil einer separaten Test-Klasse:
    * Tests sind klar von Quellcode abgekapselt, dadurch ist der wichtige Quellcode komprimierter und bei der Entwicklung
    * kann man sich jeweils auf den Test oder die Logik fokusieren. Wenn alle Testfälle gesammelt zu finden sind, ist die Uebersichtlichkeit
    * wesentlich häher und fehlende Testfälle sin dschneller aufgedeckt.
    *
    * Sinn Äquivalenzklasse bei Blackbox
    * Durch das Bilden von Äquivalenzklassen werden die zu prüfenden Werte wesentlich eingeschränkt, sodass nur
    * sinnvolle Bereiche angefragt werden. Das zufällige Auffinden von Fehlern wird durch sinnvolle Fällen abgelöst
    * für die man sich extra Gedanken machen musste, womit das Testen auch effizienter ist.
    *
    * Blackboxtest mit JUnit nicht unmittelbar durchführbar:
    * Dies ist nicht möglich, da einer GUI der Output abhängig von der Benutzereingabe über jene GUI
    * geprüft werden muss. Dies kann lediglich mit einer GUI Testsoftware z.B. Qt GUI Test Automation
    * oder händisch geprüft werden, da auch andere Faktoren neben dem Ergebnis wichtig sind.
    *
    * 
    * UML befindet sich auf einer Ebene mit control, test und org.hbrs.se.ws20.uebung4.view!
    */
}
