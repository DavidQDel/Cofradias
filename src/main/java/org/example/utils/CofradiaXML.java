package org.example.utils;

import org.example.model.Cofradia;
import org.example.model.CofradiaWrapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class CofradiaXML {
    public static void serializarAXml(CofradiaWrapper cofradiaWrapper, String filePath)
        throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CofradiaWrapper.class, Cofradia.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(cofradiaWrapper, new File(filePath));
    }

    public static CofradiaWrapper deserializarDesdeXml(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CofradiaWrapper.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (CofradiaWrapper) unmarshaller.unmarshal(new File(filePath));
    }
}
