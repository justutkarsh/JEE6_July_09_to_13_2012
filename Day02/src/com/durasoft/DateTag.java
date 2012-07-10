package com.durasoft;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DateTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println(new Date());
	}
}
