package com.ly.provider.sys.dao;

import com.ly.provider.sys.entity.TtUser;
import java.util.Map;
import java.util.List;



/**
 * 
 * 
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-23 15:22:38
 */
public interface TtUserDao  {
    List<TtUser> queryList(Map<String, Object> map);

    public TtUser selectById(Long userId);

    public int insertTtUser(TtUser ttUser);

    public int updateTtUser(TtUser ttUser);

    public int deleteTtUserByIds(String ids);

    int queryTotal(Map<String, Object> map);

    public TtUser  selectUserByUserName(String userName);
}
