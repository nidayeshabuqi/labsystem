package com.qfedu.labsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Lab;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LabMapper extends BaseMapper<Lab> {


}
