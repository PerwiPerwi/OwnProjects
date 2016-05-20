package pl.sda.service.rest;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/kantor")
public class Kantor {

	private final static double KURS_EURO = 4.21;

	@GET
	@Path("/kursEuro")
	public String getKursEuro() {
		DecimalFormat df = new DecimalFormat(".00");
		return df.format(KURS_EURO);

	}

	@GET
	@Path("/przelicz/{ile}")
	public String countCurrency(@PathParam("ile") Double howMany) {
		double euroCurrency = Double.parseDouble(getKursEuro());
		if (howMany == null) {
			return "Is empty";
		}
		return Double.toString(howMany / euroCurrency);

	}
}
