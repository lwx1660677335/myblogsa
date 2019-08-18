package blog.com.dao;

import blog.com.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDao {
    public List<SysUser> findByUname(@Param(value = "name") String name);
}
