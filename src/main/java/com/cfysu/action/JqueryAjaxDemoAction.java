package com.cfysu.action;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.util.AjaxUtil;
import com.opensymphony.xwork2.ActionSupport;

public class JqueryAjaxDemoAction extends ActionSupport {

	private static final long serialVersionUID = 8274205788235615523L;
	private String staticPath = "/statics";

	public void getJSON(){
		User user = new User((short) 1, "张三", "我是张三的密码");
		AjaxUtil.send(JSON.toJSONString(user));
	}
	
	public String demoIndex(){

		return SUCCESS;
	}

	public String getStaticPath() {
		return staticPath;
	}

	public void setStaticPath(String staticPath) {
		this.staticPath = staticPath;
	}
}
