package com.ncu.bookstore.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
public class Common {
    public static Map<String,Object> getRes(Object data, int code, String message){
        Map<String,Object> res = new HashMap<String, Object>();
        if(data!=null) res.put("data",data);
        res.put("code",code);
        res.put("message",message);

        return res;
    }
    /**
     * 封装操作文件方法， 添加用户 和修改用户都会用到
     * @param file
     * @param filePath
     * @return
     */
    public static String fileOperate(MultipartFile file, String filePath) {
        String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
        System.out.println("图片原始名称："+originalFileName);
        String newFileName = UUID.randomUUID()+originalFileName;  //新的文件名称
        System.out.println("新的文件名称："+newFileName);
        File targetFile = new File(filePath,newFileName); //创建新文件
        try {
            file.transferTo(targetFile); //把本地文件上传到文件位置 , transferTo()是springmvc封装的方法，用于图片上传时，把内存中图片写入磁盘
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFileName;
    }
}
