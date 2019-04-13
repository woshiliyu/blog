package com.ly.provider.sys.Service;


import com.ly.common.utils.rest.PageUtils;
import com.ly.provider.sys.entity.TtMenu;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ly
 * @email 513422479@qq.com
 * @date 2019-01-15 22:35:27
 */
public interface TtMenuService {

    public List<Map<String, Object>> queryList(Map<String, Object> map);

    public TtMenu selectById(Integer id);

    public int insertTtMenu(TtMenu ttMenu);

    public int updateTtMenu(TtMenu ttMenu);

    public int deleteTtMenuByIds(String ids);

    int queryTotal(Map<String, Object> map);
}

