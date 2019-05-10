package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.Shopping;
import com.ncu.bookstore.service.ShoppingService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/5/1/001
 */
@CrossOrigin
@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @Resource
    private ShoppingService shoppingService;

    @RequestMapping(value="/selectShopping",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectShopping(@RequestBody Shopping shopping){
        List<Shopping> shoppingList=shoppingService.selectShopping(shopping);
        if(!shoppingList.isEmpty()){
            return Common.getRes(shoppingList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/insertShopping",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertShopping(@RequestBody Shopping shopping){
        int i=shoppingService.insertShopping(shopping);
        if(i==1){
            return Common.getRes(shoppingService.selectShopping(shopping),1000,"success");
        }else{
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/updateShopping",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateShopping(@RequestBody Shopping shopping){
        int i=shoppingService.updateShopping(shopping);
        if(i==1){
            return Common.getRes(shoppingService.selectShopping(shopping),1000,"success");
        }else{
            return Common.getRes(null,1002,"data update failure");
        }
    }

    @RequestMapping(value="/deleteShopping",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteShopping(@RequestBody Shopping shopping){
        int i=shoppingService.deleteShopping(shopping);
        if(i==1){
            return Common.getRes(shoppingService.selectShopping(shopping),1000,"success");
        }else{
            return Common.getRes(null,1002,"data deletion failure");
        }
    }
}
