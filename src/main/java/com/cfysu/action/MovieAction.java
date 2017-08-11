package com.cfysu.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.cfysu.model.User;
import com.cfysu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Value;

public class MovieAction extends ActionSupport {

	@Value("${path}")
	private String DEFAULT_PATH;
	@Value("${ip.address}")
	private String ipAddress;
	@Value("${pwd:1425}")
	private String pwd;
	private String STATICS_PRE;
	private String authResult;
	private static final long serialVersionUID = -5426493013497319224L;

	@Resource
	private UserService userService;

	public String index() {
		System.out.println("testAction");
		//test git
		STATICS_PRE = "/statics";
		return SUCCESS;
	}

	/**
	 * 返回文件目录
	 */
	public void list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = null;
		try {
			path = new String(request.getParameter("path").getBytes("ISO8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtils.isBlank(path)){
			path = DEFAULT_PATH;
		}
		StringBuilder sb = new StringBuilder();
		try {
			File rootFile = new File(path);
			File[] files = rootFile.listFiles();
			for (File file : files) {
				sb.append(file.getAbsolutePath() + ",");
			}
		} catch (Exception e) {
			e.printStackTrace();
			returnAjaxResponse("路径错误，亲");
			return;
		}

		try {
			returnAjaxResponse(sb.toString());
		} catch (Exception e) {
		}
		//System.out.println(new Date() + ":" + sb.toString());
	}

	/**
	 * 身份认证
	 */
	public String auth() {
		if (pwd.equals(ServletActionContext.getRequest().getParameter("pwd"))) {
			authResult = "1";
		} else {
			authResult = "0";
		}
		return SUCCESS;
	}

	private void returnAjaxResponse(String msg) {
		try {
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(msg);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (Exception e) {
		}
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getSTATICS_PRE() {
		return STATICS_PRE;
	}

	public void setSTATICS_PRE(String sTATICS_PRE) {
		STATICS_PRE = sTATICS_PRE;
	}

	public String getAuthResult() {
		return authResult;
	}

	public void setAuthResult(String authResulst) {
		this.authResult = authResulst;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getDEFAULT_PATH() {
		return DEFAULT_PATH;
	}

	public void setDEFAULT_PATH(String DEFAULT_PATH) {
		this.DEFAULT_PATH = DEFAULT_PATH;
	}
}
