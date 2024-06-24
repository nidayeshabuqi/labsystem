package com.qfedu.labsystem.controller;

import com.qfedu.labsystem.VO.ChartVO;
import com.qfedu.labsystem.pojo.Equipment;
import com.qfedu.labsystem.service.EquipmentService;
import com.qfedu.labsystem.utils.ResultOBJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminapi/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getEquipmentList(){
        return equipmentService.getEquipList();
    }

    @GetMapping("/chart")
    public List<ChartVO> getChartList(){
        return equipmentService.getChartList();
    }

    @DeleteMapping(value = "/{id}")
    public ResultOBJ deleteEquipList(@PathVariable Integer id){
        try {
            equipmentService.deleteLabList(id);
            return ResultOBJ.DELETE_SUCCESS;
        } catch (Exception e) {
//           throw new RuntimeException(e);
            return  ResultOBJ.DELETE_ERROR;
        }
    }

    @PutMapping(value="/{id}")
    public  ResultOBJ updateLabList(@PathVariable Integer id,@RequestBody Equipment equip){
        try {
            equip.setId(id);
            equipmentService.updateEquipList(equip);
            return  ResultOBJ.UPDATE_SUCCESS;
        } catch (Exception e) {
//            throw new RuntimeException(e);
            return ResultOBJ.UPDATE_ERROR;
        }
    }
}
