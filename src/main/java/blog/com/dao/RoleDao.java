package blog.com.dao;

import blog.com.entity.Role;

import java.util.List;

public interface RoleDao {
    public List<Role> findRoleNameByPowerID(List<String> list) throws Exception;
}
