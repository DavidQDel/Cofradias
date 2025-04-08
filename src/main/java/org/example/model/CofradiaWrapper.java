package org.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "semana_santa")
@XmlAccessorType(XmlAccessType.FIELD)
@JacksonXmlRootElement(localName = "semana_santa")
public class CofradiaWrapper {

    @JsonProperty("cofradias")
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "cofradia")
    @XmlElement(name = "cofradia")
    private List<Cofradia> cofradias;

    //Constructor para Jackson
    @JsonCreator
    public CofradiaWrapper(@JsonProperty("cofradias") List<Cofradia> cofradias) {
        this.cofradias = cofradias;
    }

    //Constructor para JAXB
    public CofradiaWrapper() {}

    public List<Cofradia> getCofradias() {return cofradias;}

    public void setCofradias(List<Cofradia> cofradias) {this.cofradias = cofradias;}
}
