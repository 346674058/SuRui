package com.myit.server.dao.baseData;

import java.util.List;
import java.util.Map;

import com.myit.server.model.baseData.CodeGen;

/**
 * 代码快照数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface CodeGenDao {

	/**
	 * 查询代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id 代码快照id
	 * @return
	 * @throws Exception
	 */
	public CodeGen findCodeSnapshotById(Long id) throws Exception;
	
	/**
	 * 根据代码类型查询代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-6-7
	 * @param codeType
	 * @return
	 * @throws Exception
	 */
	public CodeGen findCodeSnapshotByCodeType(String codeType) throws Exception;

	/**
	 * 查询所有代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 * @throws Exception
	 */
	public List<CodeGen> findAllCodeSnapshots() throws Exception;

	/**
	 * 获取代码快照总数<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-29
	 * @param codeSnapshot
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public int getCodeSnapshotsCount(CodeGen codeSnapshot,
			Map<String, Object> param) throws Exception;

	/**
	 * 分页查询代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param start 起始记录数
	 * @param pageSize 截至记录数
	 * @param codeSnapshot 查询实体
	 * @param param 扩展查询
	 * @return
	 * @throws Exception
	 */
	public List<CodeGen> findCodeSnapshots(int start, int pageSize, CodeGen codeSnapshot,
			Map<String, Object> param) throws Exception;

	/**
	 * 保存/更新代码快照基本信息<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param codeSnapshot 保存(id = null), 更新(id != null)
	 * @return
	 * @throws Exception
	 */
	public boolean persistCodeSnapshot(CodeGen codeSnapshot) throws Exception;
}
