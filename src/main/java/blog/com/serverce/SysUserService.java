package blog.com.serverce;

import blog.com.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {
    /**
     * 根据名字查找所有信息
     * @param name
     * @return
     */
    public List<SysUser> findByUname(String name, int pageNum, int pageSize) throws  Exception;
    /**
     * 根据用户名查找信息锁定账号
     * @param sysUser
     * @return
     */
    public int updateByUnameForLockedState(SysUser sysUser);
    /**
     * 根据名字查找信息禁用账号
     * @param SysUser
     * @return
     */
    public int updateByUnameForDiscontinuedState(@Param("SysUser") SysUser SysUser);

    /**
     * 获取除密码以外所有用户信息
     * @return
     */
    List<SysUser> AllUser(int pageNum, int pageSize);
    /**
     * 添加新用户
     * @param sysUser
     * @return
     */
    int addUser(@Param("sysUser") SysUser sysUser);

    /**
     * 修改用户信息
     * @param sysUser
     * @return
     */
    int updateUser(@Param("sysUser") SysUser sysUser);
    /**
     * 根据用户key查询关联角色表
     * @param userid
     * @return
     */
    List<SysUser> findByUserKey(List<String> userid);

    /**
     * 根据key删除用户
     * @param userid
     * @return
     */
    int deleteUsers(List<String> userid);
}
