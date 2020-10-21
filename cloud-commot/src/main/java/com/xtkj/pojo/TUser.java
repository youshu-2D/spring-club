package com.xtkj.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName("tb_user")
@Data
public class TUser implements Serializable {

    private static final long serialVersionUID = 223141695029159555L;
    @TableId(value = "user_id", type = IdType.INPUT)
    private Integer userId;
    @TableField("user_name")
    private String userName;
    @TableField("login_id")
    private String loginId;
    @TableField("login_pwd")
    private String loginPwd;
}
