package com.wah.oa.manager.core.account.dao.mapper;

import com.wah.oa.manager.core.account.entity.Account;
import com.wah.persistence.mybatis.helper.criteria.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountMysqlMapper{

    void save(Account account);

    void update(Account account);

    Account get(@Param("params") Criteria criteria);

    List<Account> find(@Param("params") Criteria criteria);

    Long count(@Param("params") Criteria criteria);
}
