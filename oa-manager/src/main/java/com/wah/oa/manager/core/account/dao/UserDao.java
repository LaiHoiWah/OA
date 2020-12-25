package com.wah.oa.manager.core.account.dao;

import com.wah.commons.utils.AssertUtils;
import com.wah.commons.utils.SnowFlakeUtils;
import com.wah.oa.manager.commons.security.exception.DataAccessException;
import com.wah.oa.manager.core.account.dao.mapper.UserMapper;
import com.wah.oa.manager.core.account.entity.Account;
import com.wah.oa.manager.core.account.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserDao{

    private static final Logger LOG = LoggerFactory.getLogger(UserDao.class);

    @Autowired
    private UserMapper mapper;

    @Autowired
    private SnowFlakeUtils snowFlakeUtils;

    public void save(User user){
        AssertUtils.notNull(user, "用户信息不能为空");
        AssertUtils.hasText(user.getAccountId(), "用户关联的账户ID不能为空");
        AssertUtils.hasText(user.getName(), "用户姓名不能为空");

        try{
            user.setId(snowFlakeUtils.getIdAsString());
            user.setCreateTime(new Date());

            mapper.save(user);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void update(User user){
        AssertUtils.notNull(user, "用户信息不能为空");
        AssertUtils.hasText(user.getId(), "用户ID不能为空");

        try{
            user.setUpdateTime(new Date());

            mapper.update(user);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}
