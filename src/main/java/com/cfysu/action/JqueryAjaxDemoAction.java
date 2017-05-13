package com.cfysu.action;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.util.AjaxUtil;
import com.opensymphony.xwork2.ActionSupport;

public class JqueryAjaxDemoAction extends ActionSupport {

	private static final long serialVersionUID = 8274205788235615523L;
	private String staticPath = "/statics";
	private String ajaxFtlPath = "/html";

	public void getJSON(){
		//test eclipse git
		User user = new User((short) 1, "张三", "我是张三的密码");
		AjaxUtil.send(JSON.toJSONString(user));
	}
	/**
	 *  博客首页
	 * @return
	 */
	public String blogIndex(){
		return SUCCESS;
	}
	
	public String article(){
		
		return SUCCESS;
	}

	public String getStaticPath() {
		return staticPath;
	}

	public void setStaticPath(String staticPath) {
		this.staticPath = staticPath;
	}

	public String getAjaxFtlPath() {
		return ajaxFtlPath;
	}

	public void setAjaxFtlPath(String ajaxFtlPath) {
		this.ajaxFtlPath = ajaxFtlPath;
	}
}
