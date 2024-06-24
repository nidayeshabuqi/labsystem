package com.qfedu.labsystem.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.labsystem.page.Ipage;
import com.qfedu.labsystem.VO.IpageVO;
import com.qfedu.labsystem.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    public List<User> getUserList(User user);

    void addUserList(User user);

    void updateUserList(User user);

    void deleteUserList(Integer id);

    IpageVO pageUserList(Ipage ipage);
}
