package com.ly.provider.sys.Service;


import com.ly.common.utils.rest.PageUtils;
import com.ly.provider.sys.entity.TtUser;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-23 15:22:38
 */
public interface TtUserService {

    public List<TtUser>  queryList(Map<String, Object> map);

    public TtUser selectById(Long userId);

    public int insertTtUser(TtUser ttUser);

    public int updateTtUser(TtUser ttUser);

    public int deleteTtUserByIds(String ids);

    int queryTotal(Map<String, Object> map);

    public TtUser  selectUserByUserName(String userName);
}

