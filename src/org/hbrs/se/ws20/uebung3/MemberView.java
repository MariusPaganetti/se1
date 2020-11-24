package org.hbrs.se.ws20.uebung3;

import java.util.ArrayList;

public class MemberView
{
   public static void dump(ArrayList<Container.Member> memberList)
   {
      String output = "";
      for (int i = 0; i<memberList.size(); i++)
      {
         System.out.print(memberList.get(i).toString()+"\n");
      }
   }
}
