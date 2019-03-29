package pl.swislowski.kamil.java.rest.nbp.xml;

import java.io.File;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import pl.swislowski.kamil.java.rest.nbp.model.Rate;

//write xml = parse xml, serialize xml, marshal xml
public class JaxbWriteXmlTest {
	public static void main(String[] args) throws JAXBException {
	
		Rate rate = new Rate();
//		InputStream inputStream = JaxbTest.class.getClassLoader().getResourceAsStream("/WEB-INF/xml/rates.xml");
		//TODO: Odszukać przykład w kodzie z getResourceAsStream z ClassLoaderem - poprawnie działający.
		
		
        JAXBContext jaxbContext = JAXBContext.newInstance(Rate.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(rate, new File("rate.xml"));
        marshaller.marshal(rate, System.out);
		
	}
}
