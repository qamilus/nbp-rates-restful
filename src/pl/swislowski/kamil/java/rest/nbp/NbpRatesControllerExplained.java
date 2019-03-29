package pl.swislowski.kamil.java.rest.nbp;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import pl.swislowski.kamil.java.rest.nbp.model.AvgResponse;
import pl.swislowski.kamil.java.rest.nbp.model.ExchangeRatesSeries;
import pl.swislowski.kamil.java.rest.nbp.model.Rate;

@Path("exchangerates/rates")
public class NbpRatesControllerExplained {

//	@GET
//	public List<Rate> avgRate(
//			@QueryParam("table") String table, 
//			@QueryParam("code") String code,
//			@QueryParam("topCount") String topCount
//			) {

	@GET
	@Path("{table}/{code}/{topCount}")
	@Produces(MediaType.APPLICATION_XML)
	public AvgResponse avgRate(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {

		AvgResponse avgResponse = null;

		try {

			System.out.println("pathParam table : " + table);
			System.out.println("pathParam code : " + code);
			System.out.println("pathParam topCount : " + topCount);

//			today, last, RRRR-MM-DD
			String periodPath = "last";

			Client client = ClientBuilder.newClient();

			// .fromUri("http://api.nbp.pl/api/exchangerates/rates/c/usd/last/10/?format=xml")

			URI uri = UriBuilder.fromUri("http://api.nbp.pl/api/exchangerates/rates").path(table).path(code)
					.path(periodPath).path(topCount).build();
			
			System.out.println("####URI : " + uri);

			WebTarget webTarget = client.target(uri);

			double avg = 0.0;

			ExchangeRatesSeries exchangeRatesSeriesResponse = webTarget.request(MediaType.APPLICATION_XML)
					.get(ExchangeRatesSeries.class);
			//   URL googleURL = new URL("http://api.nbp.pl/api/exchangerates/rates/c/usd/last/10/?format=xml");
//	        URLConnection urlConnection = googleURL.openConnection();
//	        urlConnection.connect();
//	        InputStream inputStream = urlConnection.getInputStream();
			List<Rate> ratesResponse = exchangeRatesSeriesResponse.getRates();

			for (Rate rate : ratesResponse) {
				String mid = rate.getMid();
				if (mid != null) {
					avg += Double.valueOf(mid);
				}
			}
			avg = avg / ratesResponse.size();

			avgResponse = new AvgResponse(avg);
			System.out.println("#### AVG : " + avgResponse);

//			String xmlResponse = webTarget.request(MediaType.APPLICATION_XML).get(String.class);
			System.out.println("#### NBP ExchangeRatesSeries : " + exchangeRatesSeriesResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return avgResponse;
	}
}
