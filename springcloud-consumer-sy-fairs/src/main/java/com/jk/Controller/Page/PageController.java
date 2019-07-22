package com.jk.Controller.Page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 23:46
 * @Description:
 */
@Controller
@RequestMapping("Page")
public class PageController {
    @CrossOrigin
    @RequestMapping("totest")
    public String totest() {
        return "Test";
    }
    @CrossOrigin
    @RequestMapping("tojjj")
    public String tojjj() {
        return "/view/aaa";
    }
    @RequestMapping("tofairsview2")
    public String tofairsview2() {
        return "/view/testfairsview";
    }

    @CrossOrigin
    @RequestMapping("tosy")
    public String tosy() {
        return "/view/Sy";
    }

    @CrossOrigin
    @RequestMapping("source=109")
    public String tosource() {
        return "/view/Tiaoban";
    }

    @CrossOrigin
    @RequestMapping("tofairsview")
    public String tofairsview() {
        return "/view/fairsview";
    }

    @CrossOrigin
    @RequestMapping("tofairsdetails")
    public String tofairsdetails() {
        return "/view/fairsdetails";
    }

    /*公司简介页面*/
    @CrossOrigin
    @RequestMapping("tobusiness")
    public String tobusiness() {
        return "/view/business";
    }
    /*招聘页面*/
    @CrossOrigin
    @RequestMapping("toopenings")
    public String toopenings() {
        return "/view/openings";
    }


    @CrossOrigin
    @RequestMapping("totest2")
    public String totest2() {
        return "/view/test";
    }
    /**
       * @Author: Mr.Zhang
       * @Description: 跳转申请页面
       * @Date: 9:25 2019/7/17
       * @param:
       * @return: java.lang.String
       * @Version: 1.0
       */
    @CrossOrigin
    @RequestMapping("toaddsite")
    public String toaddsite() {
        return "/view/addsite";
    }

    /**
       * @Author: Mr.Zhang
       * @Description: 跳转详情页面
       * @Date: 21:08 2019/7/17
       * @param:
       * @return: java.lang.String
       * @Version: 1.0
       */
    @CrossOrigin
    @RequestMapping("tojianlixiangqing")
    public String tojianlixiangqing() {
        return "/view/jianlixiangqing";
    }


}
