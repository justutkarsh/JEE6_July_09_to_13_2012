package com.durasoft;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class SampleBean implements SampleBeanRemote, SampleBeanLocal {
	public String getInfo(){
		return "getInfo called on " + this;
	}
}
