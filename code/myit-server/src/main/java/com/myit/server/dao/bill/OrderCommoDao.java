package com.myit.server.dao.bill;

import java.util.List;

import com.myit.server.model.bill.OrderCommo;

/**
 * 订单物品数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface OrderCommoDao {

	/**
	 * 查询订单物品<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id
	 *            订单主键
	 * @return
	 * @throws Exception
	 */
	public OrderCommo findOrderGoodsById(String id) throws Exception;

	/**
	 * 分页查询订单物品<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param oId 订单id
	 * @return
	 * @throws Exception
	 */
	public List<OrderCommo> findOrderGoodsByOId(Long oId) throws Exception;

	/**
	 * 保存订单物品信息<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param orderGoods
	 *            : 保存(id = null), 更新(id != null)
	 * @return
	 * @throws Exception
	 */
	public boolean persistOrderGoods(OrderCommo orderGoods) throws Exception;

	/**
	 * 删除订单物品<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param orderGoods
	 * @return
	 * @throws Exception
	 */
	public boolean deleteOrderGoods(OrderCommo orderGoods) throws Exception;
	
	/**
	 * 删除订单物品<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param oId：订单id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteOrderGoodsByOId(Long oId) throws Exception;
}
