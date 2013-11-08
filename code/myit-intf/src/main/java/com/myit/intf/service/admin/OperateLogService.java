package com.myit.intf.service.admin;

import java.util.List;

import com.myit.intf.bean.admin.OperateLogEvt;

/**
 * 用户操作日志管理业务处理接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface OperateLogService {
    /**
     * 查询用户操作日志<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param id 用户操作日志主键
     * @return
     * @throws Exception
     */
    public OperateLogEvt findOperateLogById(Long id) throws Exception;

    /**
     * 查询所有用户操作日志<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @return
     * @throws Exception
     */
    public List<OperateLogEvt> findAllOperateLogs() throws Exception;

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
    public int getOperateLogsCount(OperateLogEvt operateLog, String[] sortParams) throws Exception;

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
    public List<OperateLogEvt> findOperateLogs(int start, int pageSize, OperateLogEvt operateLog, String[] sortParams)
            throws Exception;

    /**
     * 保存用户操作日志<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param operateLog
     * @return
     * @throws Exception
     */
    public String saveOperateLog(OperateLogEvt operateLog) throws Exception;
}
