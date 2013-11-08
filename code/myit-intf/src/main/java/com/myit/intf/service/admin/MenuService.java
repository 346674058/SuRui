package com.myit.intf.service.admin;

import java.util.List;

import com.myit.common.beans.PageQueryParam;
import com.myit.common.beans.PageQueryResult;
import com.myit.intf.bean.admin.Menu;

/**
 * 菜单管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface MenuService {
	/**
	 * 查询菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id 菜单id
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
	 * @author created by LiuCongwen at 2012-4-29
	 * @param plate
	 * @return
	 * @throws Exception
	 */
	public int getMenusCount(Menu plate) throws Exception;

	/**
	 * 分页查询菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-7-5
	 * @param pageQueryParam
	 * @return
	 * @throws Exception
	 */
	public PageQueryResult<Menu> findMenus(PageQueryParam<Menu> pageQueryParam)
			throws Exception;

	/**
	 * 保存菜单<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param plate
	 * @return
	 * @throws Exception
	 */
	public boolean saveMenu(Menu plate) throws Exception;
	
	/**
	 * 功能描述: <br>
	 * 获取登录用户菜单列表
	 *
	 * @param rId
	 * @return
	 * @throws Exception
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public List<Menu> getLoginMenus(Long uId) throws Exception;
	
	/**
	 * 功能描述: <br>
	 * 获取子菜单列表
	 *
	 * @param mId
	 * @return
	 * @throws Exception
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	public List<Menu> findChildMenus(Long mId) throws Exception;
}
