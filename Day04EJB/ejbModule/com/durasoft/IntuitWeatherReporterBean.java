package com.durasoft;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class IntuitWeatherReporterBean implements IntuitWeatherReporter {

	@PostConstruct
	public void initialize(){
		System.out.println("Initialize called on " + this);
	}
	public String getInfo(){
		return this + "---getInfo called";
	}
	public String getTemperature(String city) {
		return this + "---Temperature of " + city + " is " + Math.random()*50;
	}
}
