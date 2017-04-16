package com.cfysu.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5426493013497319224L;

	public String test(){
		System.out.println("testAction");
		return SUCCESS;
	}
}
