package com.cfysu.dao;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * Created by cj on 2017/7/31.
 * Mybatis基类
 */
public class BaseDao {

    @Resource
    private SqlSession sqlSessionTemplate;

    private static final String SQL_SEPARATOR = ".";

    public SqlSession getSqlSession() {
        return this.sqlSessionTemplate;
    }

    public String getSqlId(String sqlId) {
        return this.getClass().getName() + SQL_SEPARATOR + sqlId;
    }
}
