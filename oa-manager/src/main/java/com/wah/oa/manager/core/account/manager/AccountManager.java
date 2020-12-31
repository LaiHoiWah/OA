package com.wah.oa.manager.core.account.manager;

import com.wah.commons.utils.AssertUtils;
import com.wah.oa.manager.commons.security.exception.*;
import com.wah.oa.manager.commons.security.stereotype.Manager;
import com.wah.oa.manager.core.account.dao.AccountMysql;
import com.wah.oa.manager.core.account.entity.Account;
import com.wah.oa.manager.core.account.entity.consts.AccountState;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class AccountManager{

    @Autowired
    private AccountMysql accountMysql;

    public void save(String username, String password){
        AssertUtils.hasText(username, "账户登录名不能为空");
        AssertUtils.hasText(password, "账户密码不能为空");

        if(accountMysql.existByUsername(username)){
            throw new AccountExistsException("账户已注册: [{0}]", username);
        }

        //TODO 密码规则校验

        //创建账户信息
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setState(AccountState.NORMAL);
        accountMysql.save(account);
    }

    public Account authenticate(String username, String password){
        AssertUtils.hasText(username, "账户登录名不能为空");
        AssertUtils.hasText(password, "账户密码不能为空");

        //查询账户
        Account account = accountMysql.getByUsername(username);

        //账户校验
        if(account == null || account.getIsDelete()){
            throw new UsernameAndPasswordNotMatchException("账户登录名或密码不正确: [{0}]", username);
        }

        //TODO 密码校验

        //状态校验
        switch(account.getState()){
            case NORMAL:
                break;
            case LOCKED:
                throw new AccountLockedException("账户被锁定: [{0}]", username);
            case FROZEN:
                throw new AccountFrozenException("账户被冻结: [{0}]", username);
            case ABNORMAL:
            default:
                throw new AccountAbnormalException("账户状态异常: [{0}]", username);
        }

        return account;
    }
}
