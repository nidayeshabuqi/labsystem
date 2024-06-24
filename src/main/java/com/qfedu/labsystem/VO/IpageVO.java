package com.qfedu.labsystem.VO;

import com.qfedu.labsystem.pojo.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Slf4j
public class IpageVO {
    private Long total;
    private List<User> data;
}
