package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.BookInfo;
import com.ncu.bookstore.service.BookInfoService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/4/29/029
 */
@Controller
@RequestMapping("/bookInfo")
public class BookInfoController {

    @Resource
    private BookInfoService bookInfoService;

    @RequestMapping(value="/insertBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertBookInfo(@RequestBody BookInfo bookInfo){
        int i=bookInfoService.insertBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(null,1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/deleteBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteBookInfo(@RequestBody BookInfo bookInfo){
        int i=bookInfoService.deleteBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(null,1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value="/updateBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateBookInfo(@RequestBody BookInfo bookInfo){
        int i=bookInfoService.updateBookInfo(bookInfo);
        if(i==1) {
            return Common.getRes(null,1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }

    @RequestMapping(value="/selectAllBookInfo",method=RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllBookInfo(){
        List<BookInfo> bookInfoList=bookInfoService.selectAllBookInfo();
        if(!bookInfoList.isEmpty()){
            return Common.getRes(bookInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
    @RequestMapping(value="/selectBookInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectBookInfo(@RequestBody BookInfo bookInfo){
        List<BookInfo> bookInfoList=bookInfoService.selectBookInfo(bookInfo);
        if(!bookInfoList.isEmpty()){
            return Common.getRes(bookInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
}
