package pl.swislowski.kamil.java.rest.nbp.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class NbpRatesClientTest {
	public static void main(String[] args) {
		
		String tablePath = "a";
		String codePath = "eur";
		String periodPath = "last";
		String topCount = "5";
		//http://api.nbp.pl/api/exchangerates/rates/c/usd/last/10/?format=xml
		
		Client client = ClientBuilder.newClient();
		
		//.fromUri("http://api.nbp.pl/api/exchangerates/rates/c/usd/last/10/?format=xml")
		
		URI uri = UriBuilder
				.fromUri("http://api.nbp.pl/api/exchangerates/rates")
				.path(tablePath)
				.path(codePath)
				.path(periodPath)
				.path(topCount)
				.build();
		
		WebTarget webTarget = client.target(uri);
		
		String xmlResponse = webTarget.request(MediaType.APPLICATION_XML).get(String.class);
		System.out.println(xmlResponse);
	}

}
