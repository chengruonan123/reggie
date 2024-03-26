package com.bunny.reggie.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/*
自定义异常类
 */
public class CustomException extends  RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
