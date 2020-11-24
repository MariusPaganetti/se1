package org.hbrs.se.ws20.uebung3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member>
{
    String datei = "src/org/hbrs/se/ws20/uebung3/ContainerData.txt";
    FileInputStream fis = null;
    FileOutputStream fos = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    @Override
    public void openConnection() throws PersistenceException
    {

    }

    @Override
    public void closeConnection() throws PersistenceException
    {
        try
        {
            oos.close();
            ois.close();
        }
        catch(Exception e)
        {

        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException, IOException
    {
        File containerFile = new File(datei);
        containerFile.createNewFile(); // if file already exists will do nothing
        try
        {
            fos = new FileOutputStream(datei);
            oos = new ObjectOutputStream(fos);
            for(int i=0; i<member.size(); i++)
            {
                oos.writeObject(member.get(i));
                //oos.writeObject();
            }
        }
        catch(Exception e)
        {
            //throw new PersistenceException("Fehler beim speichern");
        }
        finally
        {
            closeConnection();
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException, IOException
    {
        fis = new FileInputStream(datei);
        ois = new ObjectInputStream(fis);

        List<Member> memberList =  new ArrayList<>();
        try
        {
            while (true) //Endlosschleife, die bei Exception zu Ende geht
            {
                memberList.add((Member) ois.readObject());
            }
        }
        catch(Exception e)
        {

        }
        finally
        {
            closeConnection();
        }
        return memberList;

        // Initiating the Stream (can also be moved to method openConnection()... ;-)
        // fis = new FileInputStream( " a location to a file" );
        // ois = new ObjectInputStream(fis);

        // Reading and extracting the list (try .. catch ommitted here)
        // Object obj = ois.readObject();

        // if (obj instanceof List<?>) {
        //       newListe = (List) obj;
        // return newListe

        // and finally close the streams (guess where this could be...?)
    }
}
