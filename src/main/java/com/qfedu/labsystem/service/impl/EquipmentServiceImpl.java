package com.qfedu.labsystem.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfedu.labsystem.VO.ChartVO;
import com.qfedu.labsystem.mapper.EquipmentMapper;

import com.qfedu.labsystem.pojo.Equipment;

import com.qfedu.labsystem.service.EquipmentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EquipmentServiceImpl extends ServiceImpl<EquipmentMapper, Equipment>  implements EquipmentService {

    @Override
    public List<ChartVO> getChartList() {
        List<Equipment> list = list(Wrappers.<Equipment>lambdaQuery());

        List<ChartVO> chartVOList = new ArrayList<>();
        for (Equipment equipment : list) {
            ChartVO chartVO = new ChartVO(equipment.getTitle(), equipment.getQuantity());
            chartVOList.add(chartVO);
        }

        return chartVOList;
    }

    @Override
    public List<Equipment> getEquipList() {
        return list(Wrappers.<Equipment>lambdaQuery());
    }

    @Override
    public void deleteLabList(Integer id) {
        removeById(id);
    }

    @Override
    public void updateEquipList(Equipment equip) {
        updateById(equip);
    }


}
