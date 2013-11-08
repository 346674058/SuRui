package com.myit.server.dao.admin;

import java.util.List;

import com.myit.server.model.admin.User;

/**
 * 用户数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface UserDao {

	/**
	 * 查询用户<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param userName
	 *            用户名
	 * @return
	 * @throws Exception
	 */
	public User findUserByUserName(String userName) throws Exception;

	/**
	 * 查询用户<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id
	 *            用户主键
	 * @return
	 * @throws Exception
	 */
	public User findUserById(Long id) throws Exception;

	/**
	 * 查询所有用户<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 * @throws Exception
	 */
	public List<User> findAllUsers() throws Exception;

	/**
	 * 获取用户记录数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param user
	 *            查询实体
	 * @param param
	 *            扩展查询
	 * @return
	 * @throws Exception
	 */
	public int getUsersCount(User user) throws Exception;

	/**
	 * 分页查询用户<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param start
	 *            起始记录数
	 * @param pageSize 页面大小
	 * @param user
	 *            查询实体
	 * @param param
	 *            扩展查询
	 * @return
	 * @throws Exception
	 */
	public List<User> findUsers(int start, int pageSize, User user) throws Exception;

	/**
	 * 保存/更新用户基本信息<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param user
	 *            : 保存(id = null), 更新(id != null)
	 * @return
	 * @throws Exception
	 */
	public boolean persistUser(User user) throws Exception;
}
