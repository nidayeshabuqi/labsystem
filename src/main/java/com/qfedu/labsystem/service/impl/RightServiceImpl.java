package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.injector.methods.DeleteById;
import com.baomidou.mybatisplus.core.injector.methods.SelectList;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.mapper.BookMapper;
import com.qfedu.labsystem.mapper.RightMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Right;
import com.qfedu.labsystem.service.RightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RightServiceImpl extends ServiceImpl<RightMapper, Right>  implements RightService {


    @Override
    public List<Right> getRightList() {
        log.info("查寻所有权限列表");

        //执行查询父节点 此时的children为空，这里需要用select标签指定要返回的字段，否则children会为空报错
        //推荐使用递归
        List<Right> parents = list(
            Wrappers.<Right>lambdaQuery()
            .eq(Right::getParentId, 0)
            .select(Right::getId,Right::getTitle,Right::getIcon,Right::getPath)
        );

        // 查询每个父节点的子节点
        for (Right parent : parents) {
            List<Right> children = list(
                Wrappers.<Right>lambdaQuery()
                .eq(Right::getParentId, parent.getId())
                .select(Right::getId,Right::getTitle,Right::getIcon,Right::getPath)
            );
            parent.setChildren(children);
        }

        return parents;
    }

    @Override
    public void updateRightlist(Right right) {
        //rightMapper.updateRightList(right);
        updateById(right);
    }

    @Override
    public void deleteRightList(Integer id) {
        //rightMapper.deleteRightList(id);
        removeById(id);
    }
}
