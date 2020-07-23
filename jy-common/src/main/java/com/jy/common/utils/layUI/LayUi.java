package com.jy.common.utils.layUI;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 彭嘉颖 on 2019/4/27.
 */
public class LayUi  extends HashMap<String, Object> {

    public static LayUi data(Integer count,List<?> data,String msg){
        LayUi r = new LayUi();
        r.put("code", 0);
        r.put("msg", msg);
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}