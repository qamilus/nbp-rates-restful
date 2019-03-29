package pl.swislowski.kamil.java.rest.nbp.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pl.swislowski.kamil.java.rest.nbp.model.Rate;

//read xml = parse xml, deserialize xml, unmarshal xml
public class JaxbReadXmlTest {
	public static void main(String[] args) throws JAXBException, FileNotFoundException {

		Rate rate;
		
		InputStream inputStream = JaxbReadXmlTest.class.getClassLoader().getResourceAsStream("/WEB-INF/xml/rates.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Rate.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		rate = (Rate) unmarshaller.unmarshal(new FileInputStream("C:\\rates.xml"));
		System.out.println(rate);
	}

}
