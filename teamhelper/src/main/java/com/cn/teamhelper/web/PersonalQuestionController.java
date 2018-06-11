package com.cn.teamhelper.web;

import com.alibaba.fastjson.JSONObject;
import com.cn.teamhelper.utils.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created  by  binbinbinfffff
 * 2018/6/11  下午8:47
 */
@Controller
public class PersonalQuestionController {
    @ResponseBody
    @RequestMapping(value = "/getPersonalQuestionByUserNum",method = RequestMethod.POST)
    public JSONObject getPersonalQuestionByUserNum(int userNum,int condition){
        return CommonUtil.constructResponse(0,null,null);
    }

}
