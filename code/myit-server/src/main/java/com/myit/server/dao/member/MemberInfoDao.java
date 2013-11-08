package com.myit.server.dao.member;

import java.util.List;
import java.util.Map;

import com.myit.server.model.member.MemberInfo;

/**
 * 客户数据访问接口<br>
 * 
 * @author created by LiuCongwen at 2012-4-24
 * @version 1.0.0
 */
public interface MemberInfoDao {

    /**
     * 查询客户<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param id 客户id
     * @return
     * @throws Exception
     */
    public MemberInfo findMemberInfoById(String id) throws Exception;

    /**
     * 
     * 功能描述: <br>
     * 根据账户查询会员，会员登录
     *
     * @param Account
     * @return
     * @throws Exception
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public MemberInfo findMemberInfosByAccount(String Account) throws Exception;

    /**
     * 查询所有客户<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @return
     * @throws Exception
     */
    public List<MemberInfo> findAllMemberInfos() throws Exception;

    /**
     * 获取客户记录数<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param memberInfo 查询实体
     * @param param 扩展查询
     * @return
     * @throws Exception
     */
    public int getMemberInfosCount(MemberInfo memberInfo, Map<String, Object> param) throws Exception;

    /**
     * 分页查询客户<br>
     * 
     * @author created by LiuCongwen at 2012-4-24
     * @param start 起始记录数
     * @param end 截至记录数
     * @param memberInfo 查询实体
     * @param param 扩展查询
     * @return
     * @throws Exception
     */
    public List<MemberInfo> findMemberInfos(int start, int end, MemberInfo memberInfo, Map<String, Object> param)
            throws Exception;

    /**
     * 保存/更新会员基本信息<br>
     * 
     * @author created by LiuCongwen at 2012-4-27
     * @param memberInfo: 保存(id = null), 更新(id != null)
     * @return
     * @throws Exception
     */
    public boolean persistMemberInfo(MemberInfo memberInfo) throws Exception;
}
