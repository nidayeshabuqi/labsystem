package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.Properties.Salt;
import com.qfedu.labsystem.mapper.UserMapper;
import com.qfedu.labsystem.page.Ipage;
import com.qfedu.labsystem.VO.IpageVO;
import com.qfedu.labsystem.pojo.Role;
import com.qfedu.labsystem.pojo.User;
import com.qfedu.labsystem.service.RoleService;
import com.qfedu.labsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService {
    @Autowired
    private RoleService roleService;
    @Autowired
    private Salt salt;
    @Override
    public List<User> getUserList(User user) {

        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtils.isNotBlank(password)) {
            password = password + salt.getSalt();
            password = DigestUtils.md5DigestAsHex(password.getBytes());
        }
        List<User> list = list(Wrappers.<User>lambdaQuery()
                .eq(StringUtils.isNotBlank(username),User::getUsername, username)
                .eq(StringUtils.isNotBlank(password),User::getPassword, password)
                .select(User::getId, User::getUsername, User::getRoleId, User::getIs_default));

        for (User user1 : list) {
            user1.setPassword("");
            Role role = roleService.getById(user1.getRoleId());
            user1.setRole(role);
        }
        return list;
    }

    @Override
    public void addUserList(User user) {
        String password = user.getPassword()+salt.getSalt();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        user.setPassword(password);

        save(user);
    }

    @Override
    public void updateUserList(User user) {
        String password = user.getPassword()+salt.getSalt();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(password);
        updateById(user);
    }

    @Override
    public void deleteUserList(Integer id) {
        removeById(id);
    }

    @Override
    public IpageVO pageUserList(Ipage ipage) {
        User user = new User();
        user.setUsername(ipage.getUsername());


        List<User> userList = getUserLikeList(user);
        Long size = Long.valueOf(userList.size());


        userList = userList.stream().skip(ipage.getPage()).limit(ipage.getSize()).collect(Collectors.toList());


        IpageVO ipageVo = new IpageVO();
        ipageVo.setTotal(size);
        ipageVo.setData(userList);
        return ipageVo;
    }


    public List<User> getUserLikeList(User user) {

        String username = user.getUsername();

        List<User> list = list(Wrappers.<User>lambdaQuery()
                .like(StringUtils.isNotBlank(username),User::getUsername, username)
                .select(User::getId, User::getUsername, User::getRoleId, User::getIs_default));

        for (User user1 : list) {
            user1.setPassword("");
            Role role = roleService.getById(user1.getRoleId());
            user1.setRole(role);
        }
        return list;
    }
}
