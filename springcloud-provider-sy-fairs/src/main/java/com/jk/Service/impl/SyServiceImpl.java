package com.jk.Service.impl;

import com.jk.Common.RedisCon;
import com.jk.Mapper.SyMapper;
import com.jk.Service.SyService;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:21
 * @Description:
 */
@Service
public class SyServiceImpl implements SyService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SyMapper symapper;

    /* *
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:21 2019/7/9
     * @param:
     * @return: java.util.List<com.jk.model.ImgBean>
     * @Version: 1.0
     */
    @Override
    public List<ImgBean> queryImg() {
        return symapper.queryImg();
    }

    /* *
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 11:12 2019/7/10
     * @param:
     * @return: com.jk.model.SyCountBeanZcy
     * @Version: 1.0
     */
    @Override
    public List<SyLineCountBeanZcy> querysycount() {
        Boolean aBoolean = redisTemplate.hasKey(RedisCon.LINECOUNT);
        if (aBoolean) {
            List range = redisTemplate.opsForList().range(RedisCon.LINECOUNT, 0, -1);
            List<SyLineCountBeanZcy> list = (List<SyLineCountBeanZcy>) range.get(0);
            return list;
        } else {
            Integer zhiweicount = symapper.queryziwei();
            Integer zicount = zicount(zhiweicount);
            symapper.updatelinecount(1, zicount);

            Integer qiyecount = symapper.queryqiyecount();
            Integer zicount1 = zicount(qiyecount);
            symapper.updatelinecount(2, zicount1);

            Integer rencaicount = symapper.queryrencaicount();
            Integer rencaicount2 = zicount(rencaicount);
            symapper.updatelinecount(3, rencaicount2);

            List<SyLineCountBeanZcy> list = symapper.querylinecount();
            redisTemplate.opsForList().leftPush(RedisCon.LINECOUNT, list);
            redisTemplate.expire(RedisCon.LINECOUNT, 24, TimeUnit.HOURS);
            return list;
        }

    }

    @Override
    public List<CompanyBean> querysyqiye() {
        return symapper.querysyqiye();
    }

    @Override
    public List<SyImgBeanZcy> querysyimg() {
        return symapper.querysyimg();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:58 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    @Override
    public List<TitleBeanZcy> queryTitle() {
        return symapper.queryTitle();
    }

    @Override
    public List<TiaoBanModelZcy> querytiaoban() {
        return symapper.querytiaoban();
    }

    public Integer zicount(Integer count) {
        Integer a = count * 999;
        return a;
    }
}
