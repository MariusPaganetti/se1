package uebung4Test;

      import org.hbrs.se.ws20.uebung4.Container;
      import org.hbrs.se.ws20.uebung4.model.ContainerException;
      import org.hbrs.se.ws20.uebung4.model.Userstory;
      import org.junit.jupiter.api.BeforeAll;
      import org.junit.jupiter.api.Test;

      import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {


   @Test
   void addUserstory() {
      Container con = new Container();
      Userstory us1 = new Userstory();
      us1.setId(1);
      try {
         con.addUserstory(us1);
      } catch ( Exception e){
         e.getMessage();
      }
      assertEquals(1, con.getCurrentList().get(0).getId());
   }

   @Test
   void resetArray() {
      Container con = new Container();
      Userstory us1 = new Userstory();
      us1.setId(1);
      try {
         con.addUserstory(us1);
      } catch ( Exception e){
         e.getMessage();
      }
      assertEquals(1, con.getCurrentList().get(0).getId());
      con.resetArray();
      assertEquals(0,con.size());
   }

   @Test
   void mergePss(){
      Container con = new Container();

      Userstory us1 = new Userstory();
      Userstory us2 = new Userstory();
      Userstory us3 = new Userstory();
      us1.setId(1);
      us2.setId();
      us3.setId();

      try {
         con.addUserstory(us1);
         con.addUserstory(us2);
      } catch (ContainerException e) {
         e.printStackTrace();
      }

      assertEquals(2,con.size());

      con.storePss();

      con.resetArray();
      assertEquals(0,con.size());

      try {
         con.addUserstory(us3);
      } catch (ContainerException e) {
         e.printStackTrace();
      }
      assertEquals(1, con.size());

      con.loadPss();
      assertEquals(3, con.size());
   }
}