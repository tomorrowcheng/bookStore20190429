package com.ncu.bookstore.util;

import java.util.HashMap;
import java.util.Map;

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
}
