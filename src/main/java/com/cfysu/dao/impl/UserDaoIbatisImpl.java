package com.cfysu.dao.impl;

import com.cfysu.dao.UsersDao;
import com.cfysu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 面向接口编程。dao层可以有多种实现。当dao层实现从mybatis变为ibatis，service层以上逻辑不需做任何改变。
 */
@Repository
public class UserDaoIbatisImpl implements UsersDao {
    public int countUser() {
        return 100;
    }

    public int insert(User record) {
        return 0;
    }

    public List<User> selectAllUser() {
        return null;
    }
}
