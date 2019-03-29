package pl.swislowski.kamil.java.rest.nbp.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ExchangeRatesSeries")
//@XmlAccessorType(XmlAccessType.FIELD)
public class ExchangeRatesSeries implements Serializable {

	@XmlElement(name = "Table")
	private String table;
	@XmlElement(name = "Currency")
	private String currency;
	@XmlElement(name = "Code")
	private String code;
	
	@XmlElementWrapper(name = "Rates") 
	@XmlElement(name = "Rate")
	private List<Rate> rates;

	public ExchangeRatesSeries() {
	}

	
	public List<Rate> getRates() {
		return rates;
	}

	@Override
	public String toString() {
		return "ExchangeRatesSeries [table=" + table + ", currency=" + currency + ", code=" + code + ", rates=" + rates
				+ "]";
	}

//	public String getTable() {
//		return table;
//	}
//
//	public void setTable(String table) {
//		this.table = table;
//	}
//
//	public String getCurrency() {
//		return currency;
//	}
//
//	public void setCurrency(String currency) {
//		this.currency = currency;
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}

	
}
