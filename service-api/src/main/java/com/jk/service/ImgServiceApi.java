package com.jk.service;

import com.jk.model.ImgBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/24 10:43
 * @Description:
 */
public interface ImgServiceApi {
    @RequestMapping("/imgcon/findimg")
    List<ImgBean> findimg();
    @RequestMapping("/imgcon/del")
    void del(@RequestParam("array") int[] array);
    @RequestMapping("/imgcon/updateout")
    void updateout(@RequestParam("array") int[] array);
    @RequestMapping("/imgcon/updatetop")
    void updatetop(@RequestParam("array") int[] array);
    @RequestMapping("/imgcon/saveimg")
    void saveimg(@RequestBody ImgBean bean);
}
