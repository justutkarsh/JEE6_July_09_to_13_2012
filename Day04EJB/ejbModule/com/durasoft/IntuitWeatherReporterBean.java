package com.durasoft;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class IntuitWeatherReporterBean implements IntuitWeatherReporter {

	public String getTemperature(String city) {
		return "Temperature of " + city + " is " + Math.random()*50;
	}
}
