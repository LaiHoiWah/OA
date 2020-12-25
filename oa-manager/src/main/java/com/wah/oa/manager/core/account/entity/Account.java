package com.wah.oa.manager.core.account.entity;

import com.wah.commons.domain.Createable;
import com.wah.commons.domain.Deleteable;
import com.wah.commons.domain.Entity;
import com.wah.commons.domain.Updateable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Account extends Entity implements Createable, Updateable, Deleteable{

    private String  username;
    private String  password;
    private Boolean isDelete;
    private Date    createTime;
    private Date    updateTime;
    private Date    deleteTime;
}
