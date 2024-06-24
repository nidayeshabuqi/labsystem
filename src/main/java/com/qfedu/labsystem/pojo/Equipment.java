package com.qfedu.labsystem.pojo;

import ch.qos.logback.core.net.ssl.SSL;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("equips")
public class Equipment {

    @TableId(value = "id", type = IdType.AUTO)
    Integer id;

    @TableField("lab_type")
    Integer lab_type;

    @TableField("equipment_type")
    Integer equipment_type;

    String title;

    @TableField("lab_name")
    String lab_name;

    Long quantity;
}
