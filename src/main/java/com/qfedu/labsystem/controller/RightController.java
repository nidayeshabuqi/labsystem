package com.qfedu.labsystem.controller;

import com.qfedu.labsystem.pojo.Right;
import com.qfedu.labsystem.service.RightService;
import com.qfedu.labsystem.utils.ResultOBJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adminapi/rights")
public class RightController {
    @Autowired
    private RightService rightService;

    @GetMapping
    public List<Right> getRightList(){
        return rightService.getRightList();
    }

    // /adminapi/rights/3
    @PutMapping("/{id}")
    public ResultOBJ updateRightList(@PathVariable Integer id, @RequestBody Right right){
        try {
            right.setId(id);
            rightService.updateRightlist(right);
            return ResultOBJ.UPDATE_SUCCESS;
        } catch (Exception e) {
            return ResultOBJ.UPDATE_ERROR;
        }
    }

    @DeleteMapping("/{id}")
    public ResultOBJ deleteRightList(@PathVariable Integer id){
        try {
            rightService.deleteRightList(id);
            return ResultOBJ.DELETE_SUCCESS;
        } catch (Exception e) {
            return ResultOBJ.DELETE_ERROR;
        }
    }
}
