package com.wah.oa.manager.core.account.entity;

import com.wah.commons.domain.Createable;
import com.wah.commons.domain.Entity;
import com.wah.commons.domain.Updateable;
import com.wah.oa.manager.core.account.entity.consts.Sex;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User extends Entity implements Createable, Updateable{

    private String accountId;
    private String name;
    private String phone;
    private String email;
    private String qq;
    private String head;
    private String img;
    private Sex    sex;
    private Date   createTime;
    private Date   updateTime;
}
