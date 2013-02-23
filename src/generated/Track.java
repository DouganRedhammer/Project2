//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.21 at 05:33:24 PM PST 
//


package generated;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

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
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Track}code"/>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Track}duration"/>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Track}trackName"/>
 *         &lt;element ref="{http://www.cs.sjsu.edu/cs157b/Track}trackComposer_id"/>
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
    "code",
    "duration",
    "trackName",
    "trackComposerId",
     "album"
})
@XmlRootElement(name = "track", namespace = "http://www.cs.sjsu.edu/cs157b/Track")
@Entity
@Table(name="Track")
public class Track {

    @XmlElement(namespace = "http://www.cs.sjsu.edu/cs157b/Track", required = true)
        protected long code;
    @XmlElement(namespace = "http://www.cs.sjsu.edu/cs157b/Track", required = true)
        protected String duration;
    @XmlElement(namespace = "http://www.cs.sjsu.edu/cs157b/Track", required = true)
        protected String trackName;
    @XmlElement(name = "trackComposer_id", namespace = "http://www.cs.sjsu.edu/cs157b/Track", required = true)
        protected long trackComposerId;
        
        private List<Album> album = new ArrayList<Album>();
    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
        @Id
    @GeneratedValue
    @Column(name="code")
    public long getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCode(long value) {
        this.code = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
        @Column(name="duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the trackName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
     @Column(name="name")
    public String getTrackName() {
        return trackName;
    }

    /**
     * Sets the value of the trackName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackName(String value) {
        this.trackName = value;
    }

    /**
     * Gets the value of the trackComposerId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Column(name="composer_id")
    public long getTrackComposerId() {
        return trackComposerId;
    }

    public void setTrackComposerId(long value) {
        this.trackComposerId = value;
    }
        @ManyToMany
    @JoinTable(name="Album_Track", 
               joinColumns={@JoinColumn(name="track_id")},
               inverseJoinColumns={@JoinColumn(name="album_id")})
    public List<Album> getAlbum() { return album; }
    public void setAlbum(List<Album> album) { this.album = album; }
   

}