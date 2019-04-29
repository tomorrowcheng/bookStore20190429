package com.ncu.bookstore.controller;

import com.ncu.bookstore.entity.Authors;
import com.ncu.bookstore.service.AuthorsService;
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
 * Created by Tomorrow on 2019/4/28/028
 */
@Controller
@RequestMapping("/authors")
public class AuthorsController {

    @Resource
    private AuthorsService authorsService;

    @RequestMapping(value = "/insertAuthor",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> insertAuthor(@RequestBody Authors authors){
        if(authors.getAuthorName()==null||authors.getDescription()==null){
            return Common.getRes(null,1001,"authorName and description can not be empty");
        }
        int i=authorsService.insertAuthor(authors);
        if(i==1) {
            return Common.getRes(authorsService.selectAllAuthors(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data insertion failure");
        }
    }

    @RequestMapping(value="/selectAllAuthors",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAllAuthors(){
        List<Authors> authorsList=authorsService.selectAllAuthors();
        if(!authorsList.isEmpty()){
            return Common.getRes(authorsList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/selectAuthors",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectAuthors(@RequestBody Authors authors){
        List<Authors> authorsList=authorsService.selectAuthors(authors);
        if(!authorsList.isEmpty()){
            return Common.getRes(authorsList,1000,"success");
        }else{
            return Common.getRes(null,1002,"no data");
        }
    }

    @RequestMapping(value="/deleteAuthor",method= RequestMethod.POST)
    public @ResponseBody Map<String,Object> deleteAuthor(@RequestBody Authors authors){
        int i=authorsService.deleteAuthor(authors);
        if(i==1) {
            return Common.getRes(authorsService.selectAllAuthors(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data deletion failure");
        }
    }

    @RequestMapping(value = "/updateAuthor",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateAuthor(@RequestBody Authors authors){
        if(authors.getAuthorName()==null&&authors.getDescription()==null){
            authors=authorsService.selectAuthors(authors).get(0);
        }
        int i=authorsService.updateAuthor(authors);
        if(i==1) {
            return Common.getRes(authorsService.selectAllAuthors(),1000,"success");
        }
        else {
            return Common.getRes(null,1002,"data update failure");
        }
    }
}
