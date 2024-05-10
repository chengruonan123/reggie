package com.bunny.reggie.controller;

import com.bunny.reggie.common.R;
import com.bunny.reggie.dto.SetmealDto;
import com.bunny.reggie.service.SetmealDishService;
import com.bunny.reggie.service.SetmealService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setmeal")
@Slf4j
/**
 * 套餐管理
 */
public class SetmealController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private SetmealDishService setmealDishService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("套餐信息：{}",setmealDto);
       setmealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功！");
    }
}
