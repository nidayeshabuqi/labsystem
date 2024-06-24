package com.qfedu.labsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("books")

public class Book {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("lab_id")
    private Integer lab_id;

    @TableField("book_time")
    private Date book_time;

    @TableField("book_class")
    private Integer book_class;

    @TableField("book_username")
    private String book_username;

    @TableField("book_reason")
    private String book_reason;

    @TableField("book_state")
    private Integer book_state;

    private Lab lab;
}
