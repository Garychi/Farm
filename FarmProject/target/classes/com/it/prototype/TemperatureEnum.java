package com.it.prototype;

public enum TemperatureEnum {
    Fahrenheit ,	Celsius ,    Kelvin ;
    
	private Double degree;
	
	public void setTempature(Double degree) {
		this.degree= degree;	
	}

	public Double getTempature() {		
		return this.degree;
	}
}
