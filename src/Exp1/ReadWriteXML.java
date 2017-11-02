package Exp1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

/**
 * Created by dmitry on 9/19/17.
 */

@XmlRootElement
public class ReadWriteXML extends metroStation {

    public ReadWriteXML(String name, Integer yearOfOpening)
    {
        super(name, yearOfOpening);
    }

    public ReadWriteXML() {
    }

    public void WriteXML(String filename){
        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(ReadWriteXML.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);


            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ReadWriteXML readXML(String filename){
        ReadWriteXML obj = new ReadWriteXML();
        try {

            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(ReadWriteXML.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            obj = (ReadWriteXML) jaxbUnmarshaller.unmarshal(file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
