package com.bunny.reggie.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bunny.reggie.entity.Setmeal;
import com.bunny.reggie.mapper.SetmealMapper;
import com.bunny.reggie.service.SetmealService;
import org.springframework.stereotype.Service;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
}
