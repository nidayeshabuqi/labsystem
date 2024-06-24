package com.qfedu.labsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qfedu.labsystem.pojo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {


    List<Book> getBookList(Book book);




}
