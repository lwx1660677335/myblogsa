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
}
