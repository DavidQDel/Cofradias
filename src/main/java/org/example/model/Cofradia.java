package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "cofradia")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cofradia implements Serializable {
    @JsonProperty("nombre")
    @JacksonXmlProperty(localName = "nombre")
    @XmlElement(name = "nombre")
    private String nombre;

    @JsonProperty("fundacion")
    @JacksonXmlProperty(localName = "fundacion")
    @XmlElement(name = "fundacion")
    private int fundacion;

    @JsonProperty("hermanos")
    @JacksonXmlProperty(localName = "hermanos")
    @XmlElement(name = "hermanos")
    private int hermanos;

    @JsonProperty("ciudad")
    @JacksonXmlProperty(localName = "ciudad")
    @XmlElement(name = "ciudad")
    private String ciudad;

    // Constructor
    public Cofradia() {}

    public Cofradia(String nombre, int fundacion, int hermanos, String ciudad) {
        this.nombre = nombre;
        this.fundacion = fundacion;
        this.hermanos = hermanos;
        this.ciudad = ciudad;
    }

    // Getters y Setters
    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getFundacion() {return fundacion;}

    public void setFundacion(int fundacion) {this.fundacion = fundacion;}

    public int getHermanos() {return hermanos;}

    public void setHermanos(int hermanos) {this.hermanos = hermanos;}

    public String getCiudad() {return ciudad;}

    public void setCiudad(String ciudad) {this.ciudad = ciudad;}


    @Override
    public String toString() {
        return "Cofradia{nombre='" + nombre + "', fundacion=" + fundacion + ", hermanos=" + hermanos +
                ", ciudad='" + ciudad + "'}";
    }
}
