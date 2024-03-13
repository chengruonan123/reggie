package com.bunny.reggie.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;


@Slf4j
@ControllerAdvice(annotations = {RestController.class, Controller.class})  //表示拦截哪一类的controller
@ResponseBody   //对json格式的数据进行返回

/**
 *全局异常处理
 */
public class GlobalExceptionHandler {

    /**
     * 异常处理方法
     * @param ex
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex) {
        log.error(ex.getMessage());

        if (ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在！";
            return R.error(msg);
        }

        return R.error("未知错误！");
    }

}
