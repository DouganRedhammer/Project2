
import generated.Album;
import generated.Artist;
import generated.Composer;

import generated.ObjectFactory;
import generated.Track;
import hibernateClasses.HibernateContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 *  Was able to combine the xml object annotation and the hibernate annotations
 * into one class. The tables must be loaded in a specific order as specified
 * in the Albums class.
 * 
 * Next; need to separate the load into their appropriate classes and try to
 * get the join table Album_track XML to hibernate to work.
 * 
 * Also need to change the name of the database to music_library instead of 
 * music_library2.
 */

/**
 *
 * @author Dougan
 */
public class Main 
{
        private static final String HELP_MESSAGE =
        "*** Commands: create, load, artists, composers, albums, quit\n";

  
    public static void main(String args[]) 
    {
        
         BufferedReader stdin = 
                new BufferedReader(new InputStreamReader(System.in));
        String command;
                Class klasses[] = {Album.class, Artist.class, 
                           Track.class, Composer.class};
        HibernateContext.addClasses(klasses);
        
        do {
            System.out.print("\nCommand? ");
            
            try {
                command = stdin.readLine();
            }
            catch (java.io.IOException ex) {
                command = "?";
            }
            
            String parts[] = command.split(" ");
            
            if (command.equalsIgnoreCase("create")) {
                HibernateContext.createSchema();
            }
            else if (command.equalsIgnoreCase("load")) {
             Artist.load();
             Album.load();
             Composer.load();
             Track.load();
 
            }
            else if (command.equalsIgnoreCase("artists")) {
               Artist.list();
            }
            else if (command.equalsIgnoreCase("composers")) {
                Composer.list();
            }
            else if (command.equalsIgnoreCase("albums")) {
                Album.list();
            }
            else if (!command.equalsIgnoreCase("quit")) {
                System.out.println(HELP_MESSAGE);
            }
        } while (!command.equalsIgnoreCase("quit"));
    }
       
    }
