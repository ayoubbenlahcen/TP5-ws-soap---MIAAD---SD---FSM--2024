
package proxy;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour conversionEuroToDH complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="conversionEuroToDH">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="mantant" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "conversionEuroToDH", propOrder = {
    "mantant"
})
public class ConversionEuroToDH {

    protected double mantant;

    /**
     * Obtient la valeur de la propriété mantant.
     * 
     */
    public double getMantant() {
        return mantant;
    }

    /**
     * Définit la valeur de la propriété mantant.
     * 
     */
    public void setMantant(double value) {
        this.mantant = value;
    }

}
