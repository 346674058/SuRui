package com.myit.server.service.admin.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myit.common.util.Constant;
import com.myit.intf.bean.admin.OperateLogEvt;
import com.myit.intf.service.admin.OperateLogService;
import com.myit.server.dao.admin.OperateLogDao;
import com.myit.server.model.admin.OperateLog;

@Service("operateLogService")
public class OperateLogServiceImpl implements OperateLogService {

    private static final Logger LOGGER = Logger.getLogger(OperateLogServiceImpl.class);

    @Autowired
    private OperateLogDao operateLogDao;

    public void setOperateLogDao(OperateLogDao operateLogDao) {
        this.operateLogDao = operateLogDao;
    }

    public OperateLogEvt findOperateLogById(Long id) throws Exception {
        LOGGER.info("findOperateLogById in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("parameters: id=" + id);
        }

        OperateLogEvt operateLogEvt = null;

        try {
            // 调用dao查询用户操作日志
            LOGGER.info("invoke OperateLogDao.findOperateLogById");
            OperateLog operateLog = operateLogDao.findOperateLogById(id);

            // 转换属性对象
            operateLogEvt = copyOperateLog2OperateLogEvt(operateLog);

        } catch (Exception e) {
            LOGGER.warn("findOperateLogById failed", e);
        }

        LOGGER.info("findOperateLogById out.");
        return operateLogEvt;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param operateLog
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private OperateLogEvt copyOperateLog2OperateLogEvt(OperateLog operateLog) {
        if (operateLog == null) {
            LOGGER.warn("operateLog is null");
            return null;
        }

        OperateLogEvt operateLogEvt = new OperateLogEvt();
        operateLogEvt.setId(operateLog.getId());

        operateLogEvt.setOpType(operateLog.getOpType());
        operateLogEvt.setOpDscribe(operateLog.getOpDscribe());
        operateLogEvt.setUserName(operateLog.getUserName());

        return operateLogEvt;
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     * 
     * @param operateLog
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private OperateLog copyOperateLogEvt2OperateLog(OperateLogEvt operateLogEvt) {
        if (operateLogEvt == null) {
            LOGGER.warn("operateLogEvt is null");
            return null;
        }

        OperateLog operateLog = new OperateLog();
        operateLog.setId(operateLog.getId());

        operateLog.setOpType(operateLogEvt.getOpType());
        operateLog.setOpDscribe(operateLogEvt.getOpDscribe());
        operateLog.setUserName(operateLogEvt.getUserName());

        return operateLog;
    }

    public List<OperateLogEvt> findAllOperateLogs() throws Exception {
        LOGGER.info("findAllOperateLogs in.");

        // TODO 调用dao查询所有用户操作日志

        LOGGER.info("findAllOperateLogs out.");
        return null;
    }

    public int getOperateLogsCount(OperateLogEvt operateLogEvt, String[] sortParams) throws Exception {
        LOGGER.info("getOperateLogsCount in.");

        // TODO 调用dao查询用户操作日志记录数
        OperateLog operateLog = null;
        int count = operateLogDao.getOperateLogsCount(operateLog, sortParams);

        LOGGER.info("getOperateLogsCount out.");
        return count;
    }

    public List<OperateLogEvt> findOperateLogs(int start, int pageSize, OperateLogEvt operateLogEvt, String[] sortParams)
            throws Exception {
        LOGGER.info("findOperateLogs in.");

        // TODO 调用dao分页查询用户操作日志
        OperateLog operateLog = null;
        List<OperateLog> operateLogs = operateLogDao.findOperateLogs(start, pageSize, operateLog, sortParams);

        List<OperateLogEvt> operateLogEvts = null;

        LOGGER.info("findOperateLogs out.");
        return operateLogEvts;
    }

    public String saveOperateLog(OperateLogEvt operateLogEvt) throws Exception {
        LOGGER.info("saveOperateLog in.");

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("operateLogEvt=" + operateLogEvt);
        }

        String retCode = Constant.UNKOEN;

        // 调用dao分别保存客户和用户操作日志信息，要求事务完整性

        try {

            OperateLog operateLog = copyOperateLogEvt2OperateLog(operateLogEvt);
            boolean isSuccess = operateLogDao.persistOperateLog(operateLog);

            if (isSuccess) {
                retCode = Constant.SUCCESS;
            } else {
                retCode = Constant.FAILED;
            }

        } catch (Exception e) {
            LOGGER.warn("persistOperateLog failed", e);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("retCode=" + retCode);
        }

        LOGGER.info("saveOperateLog out.");
        return retCode;
    }
}
