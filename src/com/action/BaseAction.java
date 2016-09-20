package com.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware{
	
	protected Map<String, Object> session;
		
	public String execute(){
		return "success";
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
