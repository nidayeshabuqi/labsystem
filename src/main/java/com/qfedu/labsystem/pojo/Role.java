package com.qfedu.labsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("roles")
public class Role {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("roleName")
    private String roleName;
    @TableField("roleType")
    private Integer roleType;
    private String rights;
}
