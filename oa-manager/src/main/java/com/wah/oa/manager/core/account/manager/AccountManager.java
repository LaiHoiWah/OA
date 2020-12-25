package com.wah.oa.manager.core.account.manager;

import com.wah.commons.utils.AssertUtils;
import com.wah.oa.manager.commons.security.exception.AccountExistsException;
import com.wah.oa.manager.commons.security.stereotype.Manager;
import com.wah.oa.manager.core.account.dao.AccountMysql;
import com.wah.oa.manager.core.account.dao.UserMysql;
import com.wah.oa.manager.core.account.entity.Account;
import com.wah.oa.manager.core.account.entity.User;
import com.wah.oa.manager.core.account.entity.consts.AccountState;
import com.wah.oa.manager.core.account.entity.consts.Sex;
import org.springframework.beans.factory.annotation.Autowired;

@Manager
public class AccountManager{

    @Autowired
    private AccountMysql accountMysql;

    @Autowired
    private UserMysql userMysql;

    public void register(String username, String password){
        AssertUtils.hasText(username, "账户登录名不能为空");
        AssertUtils.hasText(password, "账户密码不能为空");

        if(accountMysql.existByUsername(username)){
            throw new AccountExistsException("账户已注册 : [{0}]", username);
        }

        //TODO 密码规则校验

        //创建账户信息
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setState(AccountState.NORMAL);
        accountMysql.save(account);

        //创建用户信息
        if(!userMysql.existByAccountId(account.getId())){
            User user = new User();
            user.setAccountId(account.getId());
            user.setName(account.getId());
            user.setSex(Sex.SECRECY);
            userMysql.save(user);
        }
    }
}
