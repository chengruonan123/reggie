package com.bunny.reggie.controller;

import com.bunny.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String> upload(MultipartFile file) {
        //file是一个临时文件，需要转存到指定位置，否则本次请求完成后的临时文件会删除
        log.info(file.toString());

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();   //abbc.jpg
        //获取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));  //.jpg
        //使用uuid重新生成文件名，防止文件名称重复造成文件覆盖
        String fileName = UUID.randomUUID().toString() + suffix;    //asxsiuwc.jpg

        //判断当前存储路径下的文件夹是否存在，如果不存在则创建
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            //将临时文件转存到指定位置
            file.transferTo(new File(basePath + fileName));
        } catch (IOException e) {
            // throw new RuntimeException(e);  自动生成的
            e.printStackTrace();    //课程上的
        }
        return R.success(fileName);
    }

    /**
     * 文件下载
     * @param name
     * @param httpServletResponse
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse httpServletResponse){

        try {
            //输入流，通过输入流读取文件内容
            FileInputStream fileInputStream=new FileInputStream(new File(basePath+name));

            //输出流，通过输出流将文件写回浏览器，在浏览器展示图片
            ServletOutputStream outputStream=httpServletResponse.getOutputStream();

            httpServletResponse.setContentType("image/jpeg");

            int len=0;
            byte[] bytes = new byte[1024];
            while ((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }

            //关闭输入输出流
            outputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
