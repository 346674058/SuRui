package com.myit.server.dao.commodity;

import java.util.List;
import java.util.Map;

import com.myit.server.model.commodity.Commodity;

/**
 * 商品数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface CommodityDao {

    /**
     * 查询商品<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param id 商品id
     * @return
     * @throws Exception
     */
    public Commodity findCommodityById(Long id) throws Exception;

    /**
     * 查询商品<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param comCode 商品编码
     * @return
     * @throws Exception
     */
    public Commodity findCommodityByComCode(String comCode) throws Exception;

    /**
     * 获取商品记录数<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param memberInfo 查询实体
     * @param param 扩展查询
     * @return
     * @throws Exception
     */
    public int getCommoditysCount(Commodity commodity, Map<String, Object> param) throws Exception;

    /**
     * 分页查询商品<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param start 起始记录数
     * @param end 截至记录数
     * @param memberInfo 查询实体
     * @param param 扩展查询
     * @return
     * @throws Exception
     */
    public List<Commodity> findCommodities(int start, int end, Commodity commodity, Map<String, Object> param)
            throws Exception;

    /**
     * 保存/更新商品信息<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param memberInfo: 保存(id = null), 更新(id != null)
     * @return
     * @throws Exception
     */
    public boolean persistCommodity(Commodity commodity) throws Exception;
}
