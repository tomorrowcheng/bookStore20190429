package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.BookInfo;
import com.ncu.bookstore.service.BookInfoService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
@CrossOrigin
@Controller
@RequestMapping("/bookInfo")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    @RequestMapping(value="/insertBookInfo",method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public @ResponseBody Map<String,Object> insertBookInfo(@RequestPart("bookInfo") BookInfo bookInfo, @RequestPart("file") MultipartFile file,  HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");
        //String filePath = request.getSession().getServletContext().getRealPath("/upload");//定义图片上传后的路径
        String filePath="D:/ideatest/bookStore20190429/bookstore/src/main/webapp/upload";
        String newFileName = Common.fileOperate(file,filePath);
        String imgPath="/upload/"+newFileName;
        bookInfo.setPicture(imgPath);
        int i=bookInfoService.insertBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(bookInfoService.selectAllBookInfo(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/deleteBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteBookInfo(@RequestBody BookInfo bookInfo){
        int i=bookInfoService.deleteBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(bookInfoService.selectAllBookInfo(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value="/updateBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateBookInfo(@RequestBody BookInfo bookInfo){
        int i=bookInfoService.updateBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(bookInfoService.selectAllBookInfo(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }

    @RequestMapping(value="/selectAllBookInfo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllBookInfo(){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Cache-Control","no-cache");
        List<BookInfo> bookInfoList=bookInfoService.selectAllBookInfo();
        if(!bookInfoList.isEmpty()){
            return Common.getRes(bookInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
    @RequestMapping(value="/selectBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectBookInfo(@RequestBody BookInfo bookInfo){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        response.setHeader("Cache-Control","no-cache");
        List<BookInfo> bookInfoList=bookInfoService.selectBookInfo(bookInfo);
        if(!bookInfoList.isEmpty()){
            return Common.getRes(bookInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
}
