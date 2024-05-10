package com.bunny.reggie.dto;

import com.bunny.reggie.entity.Setmeal;
import com.bunny.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;//套餐关联的菜品集合

    private String categoryName;//分类名称


}