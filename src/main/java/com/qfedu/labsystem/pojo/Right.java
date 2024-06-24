package com.qfedu.labsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data
@TableName("rights")
public class Right {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String icon;

    private String path;

    @TableField("parent_id")
    private Integer parentId;

    private List<Right> children;
}
