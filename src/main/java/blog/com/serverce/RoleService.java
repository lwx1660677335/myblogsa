package blog.com.serverce;

import blog.com.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> findRoleNameByPowerID(List<String> powerId) throws Exception;
}
