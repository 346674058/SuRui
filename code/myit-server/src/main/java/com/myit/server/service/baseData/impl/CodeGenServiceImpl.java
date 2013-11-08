package com.myit.server.service.baseData.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myit.common.util.StringConvert;
import com.myit.intf.bean.baseData.CodeGenEvt;
import com.myit.intf.service.baseData.CodeGenService;
import com.myit.server.dao.baseData.CodeGenDao;
import com.myit.server.model.baseData.CodeGen;

@Service("codeGenService")
public class CodeGenServiceImpl implements CodeGenService {

	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CodeGenDao codeSnapshotDao;

	public CodeGenEvt findCodeSnapshotById(Long id) throws Exception {
		logger.info("findCodeSnapshotById in.");

		if (logger.isDebugEnabled()) {
			logger.debug("parameters: id=" + id);
		}

		CodeGen codeSnapshot = null;

		try {
			// 调用dao查询代码快照
			logger.info("invoke codeSnapshotDao.findCodeSnapshotById");
			codeSnapshot = codeSnapshotDao.findCodeSnapshotById(id);

			if (logger.isDebugEnabled()) {
				logger.debug("codeSnapshot=" + codeSnapshot);
			}
		} catch (Exception e) {
			logger.warn("findCodeSnapshotById failed", e);
		}

		logger.info("findCodeSnapshotById out.");
		return null;
	}

	public List<CodeGenEvt> findAllCodeSnapshots() throws Exception {
		logger.info("method in.");

		// TODO 调用dao查询所有代码快照

		logger.info("method out.");
		return null;
	}

	public int getCodeSnapshotsCount(CodeGen codeSnapshot,
			Map<String, Object> param) throws Exception {
		logger.info("getCodeSnapshotsCount in.");

		int codeSnapshotsCount = 0;

		try {
			// 调用dao查询代码快照记录数
			codeSnapshotsCount = codeSnapshotDao.getCodeSnapshotsCount(codeSnapshot, param);
		} catch (Exception e) {
			logger.warn("Exception occured", e);
		}

		logger.info("getCodeSnapshotsCount out.");
		return codeSnapshotsCount;
	}

	public Map<String, Object> findCodeSnapshots(int start, int pageSize, CodeGenEvt codeSnapshot,
			Map<String, Object> param) throws Exception {
		logger.info("findCodeSnapshots in.");

		if (logger.isDebugEnabled()) {
			logger.debug("parameters: start=" + start + ", end=" + pageSize
					+ ", codeSnapshot=" + codeSnapshot);
		}

		int totalCount = 0;
		List<CodeGen> codeSnapshots = null;

		try {
			// 调用dao查询代码快照总数
			totalCount = codeSnapshotDao.getCodeSnapshotsCount(null, param);

			if (totalCount > 0) {
				// 调用dao分页查询代码快照
				codeSnapshots = codeSnapshotDao.findCodeSnapshots(start, pageSize, null, param);
			}
		} catch (Exception e) {
			logger.warn("Exception occured", e);
		}

		if (StringConvert.isEmpty(codeSnapshots)) {
			logger.warn("codeSnapshots is null");
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("totalCount=" + totalCount + ",codeSnapshots.size="
						+ codeSnapshots.size());
			}
		}

		Map<String, Object> retMap = new HashMap<String, Object>();
		retMap.put("totalCount", totalCount);
		retMap.put("codeSnapshots", codeSnapshots);

		logger.info("findCodeSnapshots out.");
		return retMap;
	}

	public boolean saveCodeSnapshot(CodeGenEvt codeSnapshot) throws Exception {
		logger.info("saveCodeSnapshot in.");

		boolean isSuccess = false;

		try {
			// 调用dao保存代码快照信息
			isSuccess = codeSnapshotDao.persistCodeSnapshot(null);
		} catch (Exception e) {
			logger.warn("saveCodeSnapshot failed", e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isSuccess=" + isSuccess);
		}

		logger.info("saveCodeSnapshot out.");
		return isSuccess;
	}
}
