package org.hbrs.se.ws20.uebung4.model;

import org.hbrs.se.ws20.uebung4.Container;

public class ContainerUtilities extends Container
{
   public static boolean storyExist(Userstory us)
   {
      return getContainerinstance().getCurrentList().contains(us);
   }

   public static boolean idExist(int id)
   {
      try
      {
         if( null != getStory(id) )
         {
            return true;
         }
         return false;
      }
      catch(Exception e)
      {
         return false;
      }
   }

   public static Userstory getStory(int id) throws ContainerException
   {
      for (int i = 0; i<getContainerinstance().size(); i++)
      {
         if (getContainerinstance().getCurrentList().get(i).getId() == id)
         {
            return getContainerinstance().getCurrentList().get(i);
         }
      }
      return null;
   }
}
