package com.bunny.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bunny.reggie.entity.Dish;
import com.bunny.reggie.mapper.DishMapper;
import com.bunny.reggie.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
