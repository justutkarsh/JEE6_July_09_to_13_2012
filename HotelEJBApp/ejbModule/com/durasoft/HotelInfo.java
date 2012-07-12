package com.durasoft;

import java.util.Date;

import javax.ejb.Remote;

@Remote
public interface HotelInfo {
	boolean getAvailability(Date start, Date end)throws Exception;
	double getRate(Date start,Date end)throws Exception;
}
