package com.qfedu.labsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("labs")
public class Lab {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private Integer capacity;

    @TableField("lab_type")
    private Integer lab_type;
    @TableField("college_type")
    private Integer college_type;

    private Integer x;
    private Integer y;
}
