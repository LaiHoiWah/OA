package com.wah.oa.manager.core.account.dao;

import com.wah.commons.utils.AssertUtils;
import com.wah.commons.utils.SnowFlakeUtils;
import com.wah.oa.manager.commons.security.exception.DataAccessException;
import com.wah.oa.manager.core.account.dao.mapper.AccountMapper;
import com.wah.oa.manager.core.account.entity.Account;
import com.wah.persistence.mybatis.helper.criteria.Criteria;
import com.wah.persistence.mybatis.helper.criteria.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class AccountDao{

    private static final Logger LOG = LoggerFactory.getLogger(AccountDao.class);

    @Autowired
    private AccountMapper mapper;

    @Autowired
    private SnowFlakeUtils snowFlakeUtils;

    public void save(Account account){
        AssertUtils.notNull(account, "账户信息不能为空");
        AssertUtils.hasText(account.getUsername(), "账户登录名不能为空");
        AssertUtils.hasText(account.getPassword(), "账户密码不能为空");
        AssertUtils.notNull(account.getState(), "账户状态不能为空");

        try{
            account.setId(snowFlakeUtils.getIdAsString());
            account.setIsDelete(false);
            account.setCreateTime(new Date());

            mapper.save(account);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public void update(Account account){
        AssertUtils.notNull(account, "账户信息不能为空");
        AssertUtils.hasText(account.getId(), "账户ID不能为空");

        try{
            account.setUpdateTime(new Date());

            mapper.update(account);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public Account getByUsername(String username){
        AssertUtils.hasText(username, "账户登录名不能为空");

        try{
            Criteria criteria = new Criteria();
            criteria.and(Restrictions.where("username").eq(username));

            return mapper.get(criteria);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }

    public boolean existByUsername(String username){
        AssertUtils.hasText(username, "账户登录名不能为空");

        try{
            Criteria criteria = new Criteria();
            criteria.and(Restrictions.where("username").eq(username));

            Long total = mapper.count(criteria);

            return (total != null && total > 0);
        }catch(Exception e){
            LOG.error(e.getMessage(), e);
            throw new DataAccessException(e.getMessage(), e);
        }
    }
}
