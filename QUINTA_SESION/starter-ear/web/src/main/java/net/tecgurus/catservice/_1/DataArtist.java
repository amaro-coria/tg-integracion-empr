
package net.tecgurus.catservice._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para data_artist complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="data_artist">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre_artista" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellido_artista" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "data_artist", propOrder = {
    "nombreArtista",
    "apellidoArtista"
})
public class DataArtist {

    @XmlElement(name = "nombre_artista", required = true)
    protected String nombreArtista;
    @XmlElement(name = "apellido_artista", required = true)
    protected String apellidoArtista;

    /**
     * Obtiene el valor de la propiedad nombreArtista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreArtista() {
        return nombreArtista;
    }

    /**
     * Define el valor de la propiedad nombreArtista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreArtista(String value) {
        this.nombreArtista = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoArtista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoArtista() {
        return apellidoArtista;
    }

    /**
     * Define el valor de la propiedad apellidoArtista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoArtista(String value) {
        this.apellidoArtista = value;
    }

}
