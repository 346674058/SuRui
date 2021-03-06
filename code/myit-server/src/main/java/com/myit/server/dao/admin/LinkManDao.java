package com.myit.server.dao.admin;

import java.util.List;
import java.util.Map;

import com.myit.server.model.admin.LinkMan;

/**
 * 用户联系人数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface LinkManDao {

	/**
	 * 查询用户联系人<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param uId
	 *            用户id
	 * @return
	 * @throws Exception
	 */
	public List<LinkMan> findLinkMansByUId(Long uId) throws Exception;
	
	/**
	 * 查询用户联系人<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id
	 *            用户联系人主键
	 * @return
	 * @throws Exception
	 */
	public LinkMan findLinkManById(Long id) throws Exception;

	/**
	 * 查询所有用户联系人<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 * @throws Exception
	 */
	public List<LinkMan> findAllLinkMans() throws Exception;

	/**
	 * 获取用户联系人记录数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param linkMan
	 *            查询实体
	 * @param param
	 *            扩展查询
	 * @return
	 * @throws Exception
	 */
	public int getLinkMansCount(LinkMan linkMan, Map<String, Object> param)
			throws Exception;

	/**
	 * 分页查询用户联系人<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param start
	 *            起始记录数
	 * @param pageSize 页面大小
	 * @param linkMan
	 *            查询实体
	 * @param param
	 *            扩展查询
	 * @return
	 * @throws Exception
	 */
	public List<LinkMan> findLinkMans(int start, int pageSize, LinkMan linkMan,
			Map<String, Object> param) throws Exception;
	
	/**
	 * 保存/更新用户联系人基本信息<br>
	 * @author created by LiuCongwen at 2012-4-27
	 * @param linkMan: 保存(id = null), 更新(id != null)
	 * @return
	 * @throws Exception
	 */
	public boolean persistLinkMan(LinkMan linkMan) throws Exception;
}
