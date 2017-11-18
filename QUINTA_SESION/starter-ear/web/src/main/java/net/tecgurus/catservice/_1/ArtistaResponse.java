
package net.tecgurus.catservice._1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artista_detail_respone" type="{http://www.tecgurus.net/catService/1.0}data_artist" maxOccurs="unbounded"/>
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
    "artistaDetailRespone"
})
@XmlRootElement(name = "artista_response")
public class ArtistaResponse {

    @XmlElement(name = "artista_detail_respone", required = true)
    protected List<DataArtist> artistaDetailRespone;

    /**
     * Gets the value of the artistaDetailRespone property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artistaDetailRespone property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtistaDetailRespone().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataArtist }
     * 
     * 
     */
    public List<DataArtist> getArtistaDetailRespone() {
        if (artistaDetailRespone == null) {
            artistaDetailRespone = new ArrayList<DataArtist>();
        }
        return this.artistaDetailRespone;
    }

}
