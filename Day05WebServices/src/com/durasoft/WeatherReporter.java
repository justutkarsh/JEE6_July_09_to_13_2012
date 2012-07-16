package com.durasoft;


public class WeatherReporter {
	
	//@Mapping("/weather/temperature/{city}")
	public String getTemperature(String city){
		return "Temperature of " + city + " is " + Math.random()*100;
	}
}
