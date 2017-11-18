
package net.tecgurus.catservice._1;

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
 *         &lt;element name="artista_detail" type="{http://www.tecgurus.net/catService/1.0}data_tx"/>
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
    "artistaDetail"
})
@XmlRootElement(name = "artista_request")
public class ArtistaRequest {

    @XmlElement(name = "artista_detail", required = true)
    protected DataTx artistaDetail;

    /**
     * Obtiene el valor de la propiedad artistaDetail.
     * 
     * @return
     *     possible object is
     *     {@link DataTx }
     *     
     */
    public DataTx getArtistaDetail() {
        return artistaDetail;
    }

    /**
     * Define el valor de la propiedad artistaDetail.
     * 
     * @param value
     *     allowed object is
     *     {@link DataTx }
     *     
     */
    public void setArtistaDetail(DataTx value) {
        this.artistaDetail = value;
    }

}
