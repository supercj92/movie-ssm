package com.cfysu.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

public class MovieAction extends ActionSupport {

	@Value("${path}")
	private String DEFAULT_PATH;
	@Value("${ip.address}")
	private String ipAddress;
	@Value("${pwd:1425}")
	private String pwd;
	private String STATICS_PRE;
	private String authResult;
	private String OP_CODE_EXIT = "sd";
	private static final long serialVersionUID = -5426493013497319224L;


	public String index() {
		System.out.println("testAction");
		//test git
		STATICS_PRE = "/statics";
		ipAddress = getServerIp();
		return SUCCESS;
	}

	/**
	 * 返回文件目录
	 */
	public void list() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String path = request.getParameter("path");

		if(StringUtils.isBlank(path)){
			path = DEFAULT_PATH;
		}

		if(OP_CODE_EXIT.equals(path)){
			try {
				Runtime.getRuntime().exec("shutdown -s");
				returnAjaxResponse("pc will shut down in one minute");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
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
			returnAjaxResponse("path is wrong");
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

	private String getServerIp() {
		try {
			return Inet4Address.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "";
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
