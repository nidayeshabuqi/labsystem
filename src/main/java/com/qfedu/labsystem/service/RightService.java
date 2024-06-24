package com.qfedu.labsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Right;

import java.util.List;

public interface RightService extends IService<Right> {
    public List<Right> getRightList();

    void updateRightlist(Right right);

    void deleteRightList(Integer id);
}
