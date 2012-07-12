package com.durasoft;

import javax.ejb.Remote;

@Remote
public interface IntuitWeatherReporter {
	String getTemperature(String city);
	String getInfo();
}
