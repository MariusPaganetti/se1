package uebung2Test;

import org.hbrs.se.ws20.uebung2.Container;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestContainer
{
   Container con;
   @BeforeEach
   public void vorBedingung()
   {
      Container con = new Container();
   }

   @Test
   public void testValues() throws Container.ContainerException
   {
      Container con = new Container();

      Container.Member membNull = null;
      Container.Member mem1 = con.new Member();
      Container.Member mem2 = con.new Member();
      Container.Member mem3 = con.new Member();

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
      /**Test korrekter String            +dump*/
      assertEquals("Member (ID = 0 )",mem1.toString());
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
