package com.wah.oa.manager.core.account.dao;

import com.wah.commons.utils.AssertUtils;
import com.wah.commons.utils.SnowFlakeUtils;
import com.wah.oa.manager.commons.security.exception.DataAccessException;
import com.wah.oa.manager.core.account.dao.mapper.UserMysqlMapper;
import com.wah.oa.manager.core.account.entity.User;
import com.wah.persistence.mybatis.helper.criteria.Criteria;
import com.wah.persistence.mybatis.helper.criteria.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserMysql{

    private static final Logger LOG = LoggerFactory.getLogger(UserMysql.class);

    @Autowired
    private UserMysqlMapper mapper;

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

    public boolean existByAccountId(String accountId){
        AssertUtils.hasText(accountId, "用户关联的账户ID不能为空");

        try{
            Criteria criteria = new Criteria();
            criteria.and(Restrictions.where("accountId").eq(accountId));

            Long total = mapper.count(criteria);

            return (total != null && total > 0);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public User getByAccountId(String accountId){
        AssertUtils.hasText(accountId, "用户关联的账户ID不能为空");

        try{
            Criteria criteria = new Criteria();
            criteria.and(Restrictions.where("accountId").eq(accountId));

            return mapper.get(criteria);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}
