package com.qfedu.labsystem.controller;

import com.qfedu.labsystem.config.JwtConfig;
import com.qfedu.labsystem.page.Ipage;
import com.qfedu.labsystem.VO.IpageVO;
import com.qfedu.labsystem.pojo.User;
import com.qfedu.labsystem.service.UserService;
import com.qfedu.labsystem.utils.ResultOBJ;
import com.qfedu.labsystem.utils.SYSConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminapi/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtConfig jwtConfig;

    @GetMapping
    public List<User> getUserList(User user){
        return userService.getUserList(user);
    }

    @PostMapping("/login")
    public ResultOBJ login(@RequestBody User user){
        try {
            List<User> list = userService.getUserList(user);
            if(list.isEmpty()){
                throw new RuntimeException();
            }
            User currentUser = list.get(0);
            String token = jwtConfig.createToken(currentUser.getUsername());//根据用户名生产token
            currentUser.setToken(token);
            return new ResultOBJ(SYSConstant.CODE_SUCCESS,SYSConstant.LOGIN_SUCCESS,currentUser);
        } catch (Exception e) {
            return new ResultOBJ(SYSConstant.CODE_ERROR,SYSConstant.LOGIN_ERROR);
        }
    }

    @PostMapping
    public ResultOBJ addUserList(@RequestBody User user){
        try {
            userService.addUserList(user);
            return ResultOBJ.ADD_SUCCESS;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResultOBJ.ADD_ERROR;
        }
    }

    @PutMapping(value="/{id}")
    public ResultOBJ updateUserList(@PathVariable Integer id,@RequestBody User user){
        try {
            user.setId(id);
            userService.updateUserList(user);
            return ResultOBJ.UPDATE_SUCCESS;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResultOBJ.UPDATE_ERROR;
        }
    }
    @DeleteMapping(value = "/{id}")
    public ResultOBJ deleteUserList(@PathVariable Integer id){
        try {
            userService.deleteUserList(id);
            return ResultOBJ.DELETE_SUCCESS;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResultOBJ.DELETE_ERROR;
        }
    }
    @GetMapping("/page")
    public ResultOBJ pageUserList(Ipage ipage){
        try {
            IpageVO ipageVo = userService.pageUserList(ipage);
            return new ResultOBJ(SYSConstant.CODE_SUCCESS,SYSConstant.PAGE_SUCCESS,ipageVo);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResultOBJ.UPDATE_ERROR;
        }
    }

}
