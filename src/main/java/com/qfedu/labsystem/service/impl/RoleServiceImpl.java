package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.mapper.BookMapper;
import com.qfedu.labsystem.mapper.RoleMapper;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Role;
import com.qfedu.labsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>  implements RoleService {

    @Override
    public List<Role> getRoleList() {
        return list(Wrappers.<Role>lambdaQuery());

    }

    @Override
    public void updateRolelist(Role role) {
        updateById(role);
    }

    @Override
    public void deleteRoleList(Integer id) {
        removeById(id);
    }
}
