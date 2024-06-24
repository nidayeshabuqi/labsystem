package com.qfedu.labsystem.controller;

import com.qfedu.labsystem.pojo.Right;
import com.qfedu.labsystem.pojo.Role;
import com.qfedu.labsystem.service.RoleService;
import com.qfedu.labsystem.utils.ResultOBJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminapi/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping
    public List<Role> getRoleList(){
        return roleService.getRoleList();
    }

    @PutMapping(value="/{id}")
    public ResultOBJ updateRoleList(@PathVariable Integer id, @RequestBody Role role){
        try {
            role.setId(id);
            roleService.updateRolelist(role);
            return ResultOBJ.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultOBJ.UPDATE_ERROR;
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResultOBJ deleteRoleList(@PathVariable Integer id){
        try {
            roleService.deleteRoleList(id);
            return ResultOBJ.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultOBJ.DELETE_ERROR;
        }
    }
}
