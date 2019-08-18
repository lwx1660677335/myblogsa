package blog.com.serverce;

import blog.com.entity.SysUser;

import java.util.List;

public interface SysUserService {
    public List<SysUser> findByUname(String name, int pageNum, int pageSize) throws  Exception;
}
