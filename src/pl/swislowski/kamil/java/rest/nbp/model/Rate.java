package pl.swislowski.kamil.java.rest.nbp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class Rate {
	
	@XmlElement(name = "No")
	private String no;
	@XmlElement(name = "EffectiveDate")
	private String effectiveDate;
	@XmlElement(name = "Mid")
	private String mid;
	
//	<No>062/A/NBP/2019</No>
//	<EffectiveDate>2019-03-28</EffectiveDate>
//	<Mid>4.2998</Mid>
	
	public Rate() {
	}
	
	public String getMid() {
		return mid;
	}

	@Override
	public String toString() {
		return "Rate [no=" + no + ", effectiveDate=" + effectiveDate + ", mid=" + mid + "]";
	}
	
	

}
