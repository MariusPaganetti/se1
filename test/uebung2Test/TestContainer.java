package uebung2Test;

import org.hbrs.se.ws20.uebung2.Container;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestContainer
{
   @Test
   public void testValues() throws Container.ContainerException
   {
      Container con = new Container();
      con.resetArray();
      Container.Member membNull = null;
      Container.Member mem1 = con.new Member(0);
      Container.Member mem2 = con.new Member(1);
      Container.Member mem3 = con.new Member(2);

      /**Test Exceptionwurf*/
      assertThrows(Container.ContainerException.class, () -> con.addMember(membNull));
      /**Test Groesse add*/
      assertEquals(0,con.size());
      con.addMember(mem1);
      assertEquals(1,con.size());
      con.addMember(mem2);
      assertEquals(2,con.size());
      /**Test memberExist*/
      assertEquals(true,con.memberExist(mem1));
      assertEquals(false,con.memberExist(mem3));
      /**Test idExist*/
      assertEquals(true,con.idExist(1));
      assertEquals(false,con.idExist(2)); //da ID noch nicht in Container hinzugefuegt

      /**Test korrekter String            +dump*/
      assertEquals("Member (ID = 0 )",mem1.toString());
      con.dump(); //haendisch ueberpruefen, muss gleich "Member (ID = 0/1) sein"
      /**Test Remove*/
      assertEquals("Member (ID = 0 ) geloescht",con.deleteMember(0)); //mem1 loeschen
      assertEquals("Kein Member mit der ID: 5 vorhanden",con.deleteMember(5));//String bei nicht vorhandener ID
      assertEquals(false,con.memberExist(mem1));
      /**Test Size nach delete*/
      assertEquals(1,con.size());
      con.deleteMember(1);
      assertEquals(0,con.size());
   }
}
