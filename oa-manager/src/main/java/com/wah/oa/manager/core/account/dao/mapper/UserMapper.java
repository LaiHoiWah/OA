package com.wah.oa.manager.core.account.dao.mapper;

import com.wah.oa.manager.core.account.entity.User;
import com.wah.persistence.mybatis.helper.criteria.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper{

    void save(User user);

    void update(User user);

    User get(@Param("params") Criteria criteria);

    List<User> find(@Param("params") Criteria criteria);

    Long count(@Param("params") Criteria criteria);
}
