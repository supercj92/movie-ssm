package com.cfysu.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.util.AjaxUtil;
import com.opensymphony.xwork2.ActionSupport;

public class JqueryAjaxDemoAction extends ActionSupport {

	private static final long serialVersionUID = 8274205788235615523L;
	private String staticPath = "/statics";
	private String ajaxFtlPath = "/html";
	//private User user;
	private String userName;
	private String type;
	
	/**
	 *  博客首页
	 * @return
	 */
	public String blogIndex(){
		return SUCCESS;
	}
	/**
	 * 获取文章 ajax、load
	 * @return
	 */
	public String article(){
		return SUCCESS;
	}
	/**
	 * 获取json数据 get、post、getJSON
	 */
	public void getJSON(){
		if("get".equals(type)) {
			User user = new User("张三", "我是张三的密码");
			AjaxUtil.send(JSON.toJSONString(user));
		}else if("post".equals(type)){
			User user = new User("hi," + userName, "我是服务端返回数据");
			AjaxUtil.send(JSON.toJSONString(user));
		}else if ("getJSON".equals(type)) {
			List<User> userList = new ArrayList<User>();
			userList.add(new User("张四", "我是张四的密码"));
			userList.add(new User("张五", "我是张五的密码"));
			userList.add(new User("张六", "我是张六的密码"));
			AjaxUtil.send(JSON.toJSONString(userList));
		}
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
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
