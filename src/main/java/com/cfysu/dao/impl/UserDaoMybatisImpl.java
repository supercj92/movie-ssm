package com.cfysu.dao.impl;

import com.cfysu.dao.BaseDao;
import com.cfysu.dao.UsersDao;
import com.cfysu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cj on 2017/7/31.
 *
 */
@Repository
public class UserDaoMybatisImpl extends BaseDao implements UsersDao {
    public int countUser() {
        return 0;
    }

    public int insert(User record) {
        return 0;
    }

    public List<User> selectAllUser() {
        return this.getSqlSession().selectList(this.getSqlId("selectAllUser"));
    }
}
