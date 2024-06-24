package com.qfedu.labsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Lab;

import java.util.List;

public interface LabService extends IService<Lab> {
    public List<Lab> getLabList(Lab lab);
    public void addLabList(Lab lab);

    void updateLabList(Lab lab);

    void deleteLabList(Integer id);
}
