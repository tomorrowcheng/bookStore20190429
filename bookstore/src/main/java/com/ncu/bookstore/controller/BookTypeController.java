package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.BookType;
import com.ncu.bookstore.service.BookTypeService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/4/28/028
 */
@CrossOrigin
@Controller
@RequestMapping("/bookType")
public class BookTypeController {

    @Resource
    private BookTypeService bookTypeService;

    @RequestMapping(value = "/insertBookType",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertBookType(@RequestBody BookType bookType){
        if(bookType.getTypeName()==null){
            return Common.getRes(null,1001,"typeName can not be empty");
        }
        int i=bookTypeService.insertBookType(bookType);
        if(i==1) {
            return Common.getRes(bookTypeService.selectAllType(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/selectAllType",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllType(){
        List<BookType> bookTypeList=bookTypeService.selectAllType();
        if(!bookTypeList.isEmpty()){
            return Common.getRes(bookTypeList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/selectBookType",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectBookType(@RequestBody BookType bookType){
        List<BookType> bookTypeList=bookTypeService.selectBookType(bookType);
        if(!bookTypeList.isEmpty()){
            return Common.getRes(bookTypeList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/deleteBookType",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteBookType(@RequestBody BookType bookType){
        int i=bookTypeService.deleteBookType(bookType);
        if(i==1) {
            return Common.getRes(bookTypeService.selectAllType(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value = "updateBookType",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateBookType(@RequestBody BookType bookType){
        if(bookType.getTypeName()==null){
            bookType=bookTypeService.selectBookType(bookType).get(0);
        }
        int i=bookTypeService.updateBookType(bookType);
        if(i==1) {
            return Common.getRes(bookTypeService.selectBookType(bookType),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }
}
