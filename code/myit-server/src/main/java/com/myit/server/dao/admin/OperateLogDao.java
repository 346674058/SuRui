package com.myit.server.dao.admin;

import java.util.List;

import com.myit.server.model.admin.OperateLog;

/**
 * 用户操作日志数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface OperateLogDao {

    /**
     * 查询用户操作日志<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param id
     *            用户操作日志主键
     * @return
     * @throws Exception
     */
    public OperateLog findOperateLogById(Long id) throws Exception;

    /**
     * 查询所有用户操作日志<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @return
     * @throws Exception
     */
    public List<OperateLog> findAllOperateLogs() throws Exception;

    /**
     * 
     * <b>Function Desc:</b><br>
     * 获取用户操作日志记录数
     * 
     * @param operateLog
     * @param sortParams
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    public int getOperateLogsCount(OperateLog operateLog, String[] sortParams) throws Exception;

    /**
     * 
     * <b>Function Desc:</b><br>
     * 分页查询用户操作日志
     * 
     * @param start
     * @param pageSize
     * @param operateLog
     * @param sortParams
     * @return
     * @throws Exception
     * @see <需要参见的其它内容>
     */
    public List<OperateLog> findOperateLogs(int start, int pageSize, OperateLog operateLog, String[] sortParams) throws Exception;

    /**
     * 保存/更新用户操作日志基本信息<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param user
     *            : 保存(id = null), 更新(id != null)
     * @return
     * @throws Exception
     */
    public boolean persistOperateLog(OperateLog operateLog) throws Exception;
}
