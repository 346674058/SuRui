package com.myit.server.dao.admin;

import java.util.List;
import java.util.Map;

import com.myit.server.model.admin.Menu;

/**
 * 菜单数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface MenuDao {

	/**
	 * 查询菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id 菜单主键
	 * @return
	 * @throws Exception
	 */
	public Menu findMenuById(Long id) throws Exception;

	/**
	 * 查询所有菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 * @throws Exception
	 */
	public List<Menu> findAllMenus() throws Exception;

	/**
	 * 获取菜单记录数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param plate 查询实体
	 * @param param 扩展查询
	 * @return
	 * @throws Exception
	 */
	public int getMenusCount(Menu plate) throws Exception;

	/**
	 * 分页查询菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param start 起始记录数
	 * @param pageSize 页面大小
	 * @param plate 查询实体
	 * @param param 扩展查询
	 * @return
	 * @throws Exception
	 */
	public List<Menu> findMenus(int start, int pageSize, Menu plate) throws Exception;
	
	/**
	 * 保存/更新菜单基本信息<br>
	 * @author created by LiuCongwen at 2012-4-27
	 * @param plate: 保存(id = null), 更新(id != null)
	 * @return
	 * @throws Exception
	 */
	public boolean persistMenu(Menu plate) throws Exception;
	
	/**
     * 功能描述: <br>
     * 获取用户对应的菜单列表
     *
     * @param rId 角色id
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Menu> findMenusByUId(Long uId) throws Exception;
    
    /**
     * 功能描述: <br>
     * 获取子菜单列表
     *
     * @param queryParam 查询参数
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Menu> findChildMenus(Map<String, Object>queryParam) throws Exception;
}
