package com.qfedu.labsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.labsystem.pojo.Book;
import com.qfedu.labsystem.pojo.Role;

import java.util.List;

public interface RoleService extends IService<Role> {
    public List<Role> getRoleList();

    void updateRolelist(Role role);

    void deleteRoleList(Integer id);
}
