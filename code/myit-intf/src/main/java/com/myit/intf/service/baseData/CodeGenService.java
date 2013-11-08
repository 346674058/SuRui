package com.myit.intf.service.baseData;

import java.util.List;
import java.util.Map;

import com.myit.intf.bean.baseData.CodeGenEvt;


/**
 * 代码快照业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface CodeGenService {


	/**
	 * 查询代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param id 代码快照id
	 * @return
	 * @throws Exception
	 */
	public CodeGenEvt findCodeSnapshotById(Long id) throws Exception;

	/**
	 * 查询所有代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @return
	 * @throws Exception
	 */
	public List<CodeGenEvt> findAllCodeSnapshots() throws Exception;

	/**
	 * 分页查询代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-24
	 * @param start 起始记录数
	 * @param pageSize 截至记录数
	 * @param codeSnapshot 查询实体
	 * @param param 扩展查询
	 * @return Map 'totalCount'-总记录数，'codeSnapshots'-代码快照列表
	 * @throws Exception
	 */
	public Map<String, Object> findCodeSnapshots(int start, int pageSize, CodeGenEvt codeSnapshot,
			Map<String, Object> param) throws Exception;

	/**
	 * 保存代码快照<br>
	 * 
	 * @author created by LiuCongwen at 2012-4-27
	 * @param codeSnapshot
	 * @return
	 * @throws Exception
	 */
	public boolean saveCodeSnapshot(CodeGenEvt codeSnapshot) throws Exception;
}
