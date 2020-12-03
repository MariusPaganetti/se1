package org.hbrs.se.ws20.uebung4.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PersistenceStrategyStream<Userstory> implements PersistenceStrategy<Userstory>
{
    String datei = "src/org/hbrs/se/ws20/uebung4/ContainerData.ser";
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
    public void save(List<Userstory> us) throws PersistenceException, IOException
    {
        File containerFile = new File(datei);
        containerFile.createNewFile(); // if file already exists will do nothing
        try
        {
            fos = new FileOutputStream(datei);
            oos = new ObjectOutputStream(fos);
            for(int i=0; i<us.size(); i++)
            {
                oos.writeObject(us.get(i));
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
    public List<Userstory> load() throws PersistenceException, IOException
    {
        fis = new FileInputStream(datei);
        ois = new ObjectInputStream(fis);

        List<Userstory> usList =  new ArrayList<>();
        try
        {
            while (true) //Endlosschleife, die bei Exception zu Ende geht
            {
                usList.add((Userstory) ois.readObject());
            }
        }
        catch(Exception e)
        {

        }
        finally
        {
            closeConnection();
        }
        return usList;

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
