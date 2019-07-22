package com.jk.Service.impl;

import com.jk.Mapper.BusinMapper;
import com.jk.Service.BusinService;
import com.jk.model.CompanyBean;
import com.jk.model.JianlibeanZcy;
import com.jk.model.UserWorkBean;
import com.jk.model.WorkBeanZcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:53
 * @Description:
 */
@Service
public class BusinServiceImpl implements BusinService {
    @Autowired
    private BusinMapper businMapper;

    @Override
    public CompanyBean queryBusinessbyid(Integer id) {
        return businMapper.queryBusinessbyid(id);
    }

    @Override
    public Integer queryworkcountbyid(Integer id) {
        return businMapper.queryworkcountbyid(id);
    }

    @Override
    public List<WorkBeanZcy> queryopnings(Integer id) {
        return businMapper.queryopnings(id);
    }

    @Override
    public List<JianlibeanZcy> queryjianli(Integer userid) {
        return businMapper.queryjianli(userid);
    }

    @Override
    public List<JianlibeanZcy> queryjianli2(Integer userid) {
        return businMapper.queryjianli2(userid);
    }

    @Override
    public JianlibeanZcy findjianlixiangqing(Integer id) {
        return businMapper.findjianlixiangqing(id);
    }

    @Override
    public void saveshenqing(UserWorkBean bean) {
        businMapper.saveshenqing(bean);
    }

    @Override
    public UserWorkBean queryuserwork(Integer userid, Integer jid,Integer zid) {
        return businMapper.queryuserwork(userid,jid,zid);
    }

    @Override
    public void updateuserwork(Integer uzid) {
        businMapper.updateuserwork(uzid);
    }
}
