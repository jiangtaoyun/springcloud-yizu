package com.jk.Service;

import com.jk.model.CompanyBean;
import com.jk.model.JianlibeanZcy;
import com.jk.model.UserWorkBean;
import com.jk.model.WorkBeanZcy;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:53
 * @Description:
 */
public interface BusinService {
    CompanyBean queryBusinessbyid(Integer id);

    Integer queryworkcountbyid(Integer id);

    List<WorkBeanZcy> queryopnings(Integer id);

    List<JianlibeanZcy> queryjianli(Integer userid);

    List<JianlibeanZcy> queryjianli2(Integer userid);

    JianlibeanZcy findjianlixiangqing(Integer id);

    void saveshenqing(UserWorkBean bean);

    UserWorkBean queryuserwork(Integer userid, Integer jid,Integer zid);

    void updateuserwork(Integer uzid);
}
