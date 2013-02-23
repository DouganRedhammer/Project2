//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.21 at 05:33:24 PM PST 
//


package generated;

import hibernateClasses.HibernateContext;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.persistence.Entity;

/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Album}id"/>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Album}artistName"/>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Album}album_id"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "artistName",
    "artist",
    "tracks"
})
@XmlRootElement(name = "album", namespace = "http://www.cs.sjsu.edu/cs157b/Album")

@Entity
@Table(name="Album")
public class Album {

    @XmlElement(namespace = "http://www.cs.sjsu.edu/cs157b/Album")
    protected long id;
    @XmlElement(namespace = "http://www.cs.sjsu.edu/cs157b/Album", required = true)
    protected String artistName;
    @XmlElement(name = "album_id", namespace = "http://www.cs.sjsu.edu/cs157b/Album")
    private Artist artist;
    private List<Track> tracks = new ArrayList<Track>();
    
    /**
     * Gets the value of the id property.
     * 
     */
    @Id
    @GeneratedValue //auto increment
    @Column(name="id")
    public long getId() {
        return id;
    }
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the artistName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Column(name="name")
    public String getArtistName() {
        return artistName;
    }
    public void setArtistName(String value) {
        this.artistName = value;
    }


        @ManyToMany
    @JoinTable(name="Album_Track", 
               joinColumns={@JoinColumn(name="album_id")},
               inverseJoinColumns={@JoinColumn(name="track_id")})
    public List<Track> getTrack() { return tracks; }
    public void setTrack(List<Track> tracks) { this.tracks = tracks; }
    
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="album_id")
    public Artist getArtist() { return artist; }
    public void setArtist(Artist artist) { this.artist = artist; }
   
    
    public static void load()
    {
        HibernateContext.createSchema();
        AlbumTable albumTbl;   
        List<Album> albums; 
        
        ArtistTable artistTbl;
        List<Artist> artists;
        
        ComposerTable composerTbl;
        List<Composer> composers;

        TrackTable trackTbl;
        List<Track> tracks;      
   try {
            JAXBContext jaxbContext =  JAXBContext.newInstance("generated"); 
            Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();


            albumTbl = (AlbumTable)unMarshaller.unmarshal(new File("album.xml"));
            albums = albumTbl.getAlbum();
            
            artistTbl = (ArtistTable)unMarshaller.unmarshal(new File("artist.xml"));
            artists = artistTbl.getArtist();
            
            composerTbl = (ComposerTable)unMarshaller.unmarshal(new File("composer.xml"));
            composers = composerTbl.getComposer();
        
            trackTbl = (TrackTable)unMarshaller.unmarshal(new File("track.xml"));
            tracks = trackTbl.getTrack();
       
            //System.out.println(tracks.get(0).getTrackName());
        
        Session session = HibernateContext.getSession();
        
        Transaction tx = session.beginTransaction();
        {
            //session.save(tracks.get(0));
            for(Composer composer: composers)
                session.save(composer);
            for(Artist artist: artists)
                session.save(artist);
            for(Album album: albums)
                session.save(album);
            for(Track track: tracks)
                session.save(track);
        }
        tx.commit();
        session.close();

        System.out.println("Album table loaded.");
            // HibernateContext.createSchema();
//ArtistHibObj.load(artists.get(1));
            
        } catch (JAXBException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    }

    }
    
