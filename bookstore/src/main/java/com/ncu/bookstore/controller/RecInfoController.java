package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.RecInfo;
import com.ncu.bookstore.service.RecInfoService;
import com.ncu.bookstore.util.Common;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Tomorrow on 2019/4/30/030
 */
@CrossOrigin
@Controller
@RequestMapping("/recInfo")
public class RecInfoController {

    @Resource
    private RecInfoService recInfoService;

    @RequestMapping(value="/insertRecInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertRecInfo(@RequestBody RecInfo recInfo){
        int i=recInfoService.insertRecInfo(recInfo);
        if(i==1){
            return Common.getRes(recInfoService.selectRecInfo(recInfo),1000,"success");
        }else{
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/deleteRecInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteRecInfo(@RequestBody RecInfo recInfo){
        int i=recInfoService.deleteRecInfo(recInfo);
        if(i==1){
            return Common.getRes(null,1000,"success");
        }else{
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value="/updateRecInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateRecInfo(@RequestBody RecInfo recInfo){
        int i=recInfoService.updateRecInfo(recInfo);
        if(i==1){
            return Common.getRes(recInfoService.selectRecInfo(recInfo),1000,"success");
        }else{
            return Common.getRes(null,1002,"data update failure");
        }
    }

    @RequestMapping(value="/selectRecInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectRecInfo(@RequestBody RecInfo recInfo){
        List<RecInfo> recInfoList=recInfoService.selectRecInfo(recInfo);
        if(!recInfoList.isEmpty()){
            return Common.getRes(recInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
}
