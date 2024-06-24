package com.qfedu.labsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qfedu.labsystem.VO.ChartVO;
import com.qfedu.labsystem.pojo.Equipment;

import java.util.List;

public interface EquipmentService extends IService<Equipment> {

    List<Equipment> getEquipList();

    void deleteLabList(Integer id);

    void updateEquipList(Equipment equip);

    List<ChartVO> getChartList();
}
