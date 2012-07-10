package com.durasoft;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PersonTag extends SimpleTagSupport{
	private String name;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println("Hello " + name +"!!!.You are " + age + " years old!!!");
	}
}
