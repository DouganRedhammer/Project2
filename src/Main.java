
import generated.Album;
import generated.Artist;
import generated.Composer;

import generated.ObjectFactory;
import generated.Track;
import hibernateClasses.HibernateContext;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
 *  The toughest part of this is correctly using the xjc command to generate
 *  the java files in the right location. The other option is to right click 
 *  the project, select new->other>XML->JAXB binding. 
 *  
 *  Select the correct XML Schema and it will do the same thing as the xjc 
 *  command
 * 
 *  In the real project it would be better to make methods for marshalling 
 *  and un-marshalling (ConvertToXML and ConvertFromXML or something like that)
 *  maybe Import and Export
 */

/**
 *
 * @author Dougan
 */
public class Main 
{
    public static void main(String args[]) 
    {
                Class klasses[] = {Album.class, Artist.class, 
                           Track.class, Composer.class};
        HibernateContext.addClasses(klasses);
      //  HibernateContext.createSchema();
        Album.load();
        
    }
       
        
}
