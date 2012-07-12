package com.durasoft;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HotelInfoBean implements HotelInfo {

	public boolean getAvailability(Date start, Date end)throws Exception {
		checkDates(start, end);
		return Math.random() < 0.5 ? true:false;
	}

	public double getRate(Date start, Date end)throws Exception {
		checkDates(start, end);
		return Math.random()*2000;
	}

	private void checkDates(Date start, Date end) throws Exception {
		if(start.after(end))
			throw new Exception("Invalid start and end date" + start + ", " + end);
	}	
}
