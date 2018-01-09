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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.oscm.saml2.api.model.xmldsig.SignatureType;

/**
 * <p>
 * Java class for RoleDescriptorType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="RoleDescriptorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}Extensions" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}KeyDescriptor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}Organization" minOccurs="0"/>
 *         &lt;element ref="{urn:oasis:names:tc:SAML:2.0:metadata}ContactPerson" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="validUntil" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="cacheDuration" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="protocolSupportEnumeration" use="required" type="{urn:oasis:names:tc:SAML:2.0:metadata}anyURIListType" />
 *       &lt;attribute name="errorURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoleDescriptorType", propOrder = { "signature", "extensions",
        "keyDescriptor", "organization", "contactPerson" })
@XmlSeeAlso({ AttributeAuthorityDescriptorType.class,
        AuthnAuthorityDescriptorType.class, PDPDescriptorType.class,
        SSODescriptorType.class })
public abstract class RoleDescriptorType {

    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#")
    protected SignatureType signature;
    @XmlElement(name = "Extensions")
    protected ExtensionsType extensions;
    @XmlElement(name = "KeyDescriptor")
    protected List<KeyDescriptorType> keyDescriptor;
    @XmlElement(name = "Organization")
    protected OrganizationType organization;
    @XmlElement(name = "ContactPerson")
    protected List<ContactType> contactPerson;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "validUntil")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar validUntil;
    @XmlAttribute(name = "cacheDuration")
    protected Duration cacheDuration;
    @XmlAttribute(name = "protocolSupportEnumeration", required = true)
    protected List<String> protocolSupportEnumeration;
    @XmlAttribute(name = "errorURL")
    @XmlSchemaType(name = "anyURI")
    protected String errorURL;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the signature property.
     * 
     * @return possible object is {@link SignatureType }
     * 
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *            allowed object is {@link SignatureType }
     * 
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return possible object is {@link ExtensionsType }
     * 
     */
    public ExtensionsType getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *            allowed object is {@link ExtensionsType }
     * 
     */
    public void setExtensions(ExtensionsType value) {
        this.extensions = value;
    }

    /**
     * Gets the value of the keyDescriptor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the keyDescriptor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getKeyDescriptor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyDescriptorType }
     * 
     * 
     */
    public List<KeyDescriptorType> getKeyDescriptor() {
        if (keyDescriptor == null) {
            keyDescriptor = new ArrayList<KeyDescriptorType>();
        }
        return this.keyDescriptor;
    }

    /**
     * Gets the value of the organization property.
     * 
     * @return possible object is {@link OrganizationType }
     * 
     */
    public OrganizationType getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *            allowed object is {@link OrganizationType }
     * 
     */
    public void setOrganization(OrganizationType value) {
        this.organization = value;
    }

    /**
     * Gets the value of the contactPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the contactPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getContactPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactType }
     * 
     * 
     */
    public List<ContactType> getContactPerson() {
        if (contactPerson == null) {
            contactPerson = new ArrayList<ContactType>();
        }
        return this.contactPerson;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the validUntil property.
     * 
     * @return possible object is {@link XMLGregorianCalendar }
     * 
     */
    public XMLGregorianCalendar getValidUntil() {
        return validUntil;
    }

    /**
     * Sets the value of the validUntil property.
     * 
     * @param value
     *            allowed object is {@link XMLGregorianCalendar }
     * 
     */
    public void setValidUntil(XMLGregorianCalendar value) {
        this.validUntil = value;
    }

    /**
     * Gets the value of the cacheDuration property.
     * 
     * @return possible object is {@link Duration }
     * 
     */
    public Duration getCacheDuration() {
        return cacheDuration;
    }

    /**
     * Sets the value of the cacheDuration property.
     * 
     * @param value
     *            allowed object is {@link Duration }
     * 
     */
    public void setCacheDuration(Duration value) {
        this.cacheDuration = value;
    }

    /**
     * Gets the value of the protocolSupportEnumeration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a
     * snapshot. Therefore any modification you make to the returned list will
     * be present inside the JAXB object. This is why there is not a
     * <CODE>set</CODE> method for the protocolSupportEnumeration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getProtocolSupportEnumeration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link String }
     * 
     * 
     */
    public List<String> getProtocolSupportEnumeration() {
        if (protocolSupportEnumeration == null) {
            protocolSupportEnumeration = new ArrayList<String>();
        }
        return this.protocolSupportEnumeration;
    }

    /**
     * Gets the value of the errorURL property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getErrorURL() {
        return errorURL;
    }

    /**
     * Sets the value of the errorURL property.
     * 
     * @param value
     *            allowed object is {@link String }
     * 
     */
    public void setErrorURL(String value) {
        this.errorURL = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed
     * property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and the value is the string
     * value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute by
     * updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
