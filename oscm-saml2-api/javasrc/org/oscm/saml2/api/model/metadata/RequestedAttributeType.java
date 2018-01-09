/*******************************************************************************
 *  Copyright FUJITSU LIMITED 2018
 *******************************************************************************/

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.22 at 03:29:00 PM CEST 
//

package org.oscm.saml2.api.model.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import org.oscm.saml2.api.model.assertion.AttributeType;

/**
 * <p>
 * Java class for RequestedAttributeType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RequestedAttributeType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:oasis:names:tc:SAML:2.0:assertion}AttributeType">
 *       &lt;attribute name="isRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestedAttributeType")
public class RequestedAttributeType extends AttributeType {

    @XmlAttribute(name = "isRequired")
    protected Boolean isRequired;

    /**
     * Gets the value of the isRequired property.
     * 
     * @return possible object is {@link Boolean }
     * 
     */
    public Boolean isIsRequired() {
        return isRequired;
    }

    /**
     * Sets the value of the isRequired property.
     * 
     * @param value
     *            allowed object is {@link Boolean }
     * 
     */
    public void setIsRequired(Boolean value) {
        this.isRequired = value;
    }

}
