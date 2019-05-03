package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.OrderInfo;
import com.ncu.bookstore.service.OrderInfoService;
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
 * Created by Tomorrow on 2019/5/1/001
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {

    @Resource
    private OrderInfoService orderInfoService;

    @RequestMapping(value="/insertOrderInfo",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertOrderInfo(@RequestBody OrderInfo orderInfo){
        int i=orderInfoService.insertOrderInfo(orderInfo);
        if(i==1){
            return Common.getRes(orderInfoService.selectOrderInfo(orderInfo),1000,"success");
        }else{
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/deleteOrderInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteOrderInfo(@RequestBody OrderInfo orderInfo){
        int i=orderInfoService.deleteOrderInfo(orderInfo);
        if(i==1){
            return Common.getRes(orderInfoService.selectOrderInfo(orderInfo),1000,"success");
        }else{
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value="/updateOrderInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateOrderInfo(@RequestBody OrderInfo orderInfo){
        int i=orderInfoService.updateOrderInfo(orderInfo);
        if(i==1){
            return Common.getRes(orderInfoService.selectOrderInfo(orderInfo),1000,"success");
        }else{
            return Common.getRes(null,1002,"data update failure");
        }
    }

    @RequestMapping(value="/selectOrderInfo",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectOrderInfo(@RequestBody OrderInfo orderInfo){
        List<OrderInfo> orderInfoList=orderInfoService.selectOrderInfo(orderInfo);
        if(!orderInfoList.isEmpty()){
            return Common.getRes(orderInfoList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }
}
