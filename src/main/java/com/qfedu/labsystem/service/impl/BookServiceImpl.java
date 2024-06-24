package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.mapper.BookMapper;
import com.qfedu.labsystem.mapper.LabMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Lab;
import com.qfedu.labsystem.service.BookService;
import com.qfedu.labsystem.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService  {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public void addBookList(Book book) {

        save(book);
    }

    @Override
    public List<Book> getBookList(Book book) {
        return bookMapper.getBookList(book);

    }

    @Override
    public void deleteBookList(Integer id) {

        removeById(id);
    }

    @Override
    public void updateBookList(Book book) {

        updateById(book);
    }
}
