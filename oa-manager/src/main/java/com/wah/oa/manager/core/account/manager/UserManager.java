package com.wah.oa.manager.core.account.manager;

import com.wah.commons.utils.AssertUtils;
import com.wah.oa.manager.commons.security.stereotype.Manager;
import com.wah.oa.manager.core.account.dao.UserMysql;
import com.wah.oa.manager.core.account.entity.User;
import com.wah.oa.manager.core.account.entity.consts.Sex;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class UserManager{

    @Autowired
    private UserMysql userMysql;

    public void save(String accountId){
        AssertUtils.hasText(accountId, "用户关联的账户ID不能为空");

        //创建用户信息
        if(!userMysql.existByAccountId(accountId)){
            User user = new User();
            user.setAccountId(accountId);
            user.setName(accountId);
            user.setSex(Sex.SECRECY);
            userMysql.save(user);
        }
    }

    public User getByAccountId(String accountId){
        AssertUtils.hasText(accountId, "用户关联的账户ID不能为空");

        //查询用户信息
        User user = userMysql.getByAccountId(accountId);

        //创建用户信息
        if(user == null){
            user = new User();
            user.setAccountId(accountId);
            user.setName(accountId);
            user.setSex(Sex.SECRECY);
            userMysql.save(user);
        }

        return user;
    }
}
