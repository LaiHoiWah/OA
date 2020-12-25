package com.wah.oa.manager.core.account.dao.mapper;

import com.wah.oa.manager.core.account.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper{

    void save(Account account);

    void update(Account account);
}
