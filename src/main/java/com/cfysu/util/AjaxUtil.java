package com.cfysu.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class AjaxUtil {

	/**
     * 发送文本内容
     * @param content
     */
    public static void send(String content) {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = null;
        try {
        	writer = response.getWriter();
        	writer.write(content);
        	writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	if(writer != null){
        		writer.close();
        	}
        }
    }
}
