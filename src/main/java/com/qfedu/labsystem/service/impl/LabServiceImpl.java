package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.mapper.BookMapper;
import com.qfedu.labsystem.mapper.LabMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Lab;
import com.qfedu.labsystem.service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabServiceImpl extends ServiceImpl<LabMapper, Lab>  implements LabService {

    @Override
    public List<Lab> getLabList(Lab lab) {

        List<Lab> list = list(Wrappers.<Lab>lambdaQuery()
                .orderByAsc(Lab::getId));
        return list;
    }

    @Override
    public void addLabList(Lab lab) {

        save(lab);
    }

    @Override
    public void updateLabList(Lab lab) {

        updateById(lab);
    }

    @Override
    public void deleteLabList(Integer id) {
        //labMapper.deleteLabList(id);
        removeById(id);
    }
}
