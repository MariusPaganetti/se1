package org.hbrs.se.ws20.uebung3;

import java.util.ArrayList;

public class MemberView
{
   public void dump(ArrayList<Member> memberList)
   {
      String output = "";
      for (int i = 0; i<memberList.size(); i++)
      {
         output+=memberList.get(i).toString()+"\n";
      }
      System.out.println(output);
   }
}
