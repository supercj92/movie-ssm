package com.cfysu.model;

public class User {

    public User(String userName, String pwd) {
		super();
		this.userName = userName;
		this.pwd = pwd;
	}

    private Short id;

    private String pwd;
    private String userName;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}