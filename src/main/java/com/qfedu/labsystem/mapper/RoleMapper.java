package com.qfedu.labsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Right;
import com.qfedu.labsystem.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
