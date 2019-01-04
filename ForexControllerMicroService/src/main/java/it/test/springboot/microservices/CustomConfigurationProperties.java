package it.test.springboot.microservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("aci")
public class CustomConfigurationProperties {

	private boolean attiva;
	private String valore1;
	private String valore2;

	public boolean isAttiva() {
		return attiva;
	}

	public void setAttiva(boolean attiva) {
		this.attiva = attiva;
	}

	public String getValore1() {
		return valore1;
	}

	public void setValore1(String valore1) {
		this.valore1 = valore1;
	}

	public String getValore2() {
		return valore2;
	}

	public void setValore2(String valore2) {
		this.valore2 = valore2;
	}

	@Override
	public String toString() {
		return "CustomConfigurationProperties [attiva=" + attiva + ", valore1=" + valore1 + ", valore2=" + valore2
				+ "]";
	}
	
	

}
