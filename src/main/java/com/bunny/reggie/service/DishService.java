package com.bunny.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bunny.reggie.dto.DishDto;
import com.bunny.reggie.entity.Dish;
import com.bunny.reggie.mapper.DishMapper;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish，dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);
}
