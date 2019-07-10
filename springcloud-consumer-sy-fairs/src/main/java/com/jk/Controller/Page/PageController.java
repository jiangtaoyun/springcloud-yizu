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
    public String totest(){
        return  "Test";
    }
    @CrossOrigin
    @RequestMapping("tosy")
    public String tosy(){
        return  "/view/Sy";
    }
    @CrossOrigin
    @RequestMapping("source=109")
    public String tosource(){
        return  "/view/Tiaoban";
    }
}
