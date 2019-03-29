package pl.swislowski.kamil.java.rest.nbp.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AvgResponse {
	
	@XmlElement
	private double avg;
	
	public AvgResponse() {
	}

	public AvgResponse(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "AvgResponse [avg=" + avg + "]";
	}
}
