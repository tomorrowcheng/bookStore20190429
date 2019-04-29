package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.Admin;
import com.ncu.bookstore.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertAdmin(@RequestBody Admin admin){
        if(admin.getAdminName()==null||admin.getAdminPassword()==null||admin.getRank()==null){
            return Common.getRes(null,1001,"adminName , description and rank can not be empty");
        }
        int i=adminService.insertAdmin(admin);
        if(i==1) {
            return Common.getRes(adminService.selectAllAdmin(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/selectAllAdmin",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllAdmin(){
        List<Admin> adminList=adminService.selectAllAdmin();
        if(!adminList.isEmpty()){
            return Common.getRes(adminList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/selectAdmin",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAdmin(@RequestBody Admin admin){
        List<Admin> adminList=adminService.selectAdmin(admin);
        if(!adminList.isEmpty()){
            return Common.getRes(adminList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/deleteAdmin",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteAdmin(@RequestBody Admin admin){
        int i=adminService.deleteAdmin(admin);
        if(i==1) {
            return Common.getRes(adminService.selectAllAdmin(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateAdmin(@RequestBody Admin admin){
        if(admin.getAdminName()==null&&admin.getAdminPassword()==null){
            admin=adminService.selectAdmin(admin).get(0);
        }
        int i=adminService.updateAdmin(admin);
        if(i==1) {
            return Common.getRes(adminService.selectAllAdmin(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }
}
