package blog.com.dao;

import blog.com.entity.Permissiongroups;

import java.util.List;

public interface PermissiongroupsDao {
    public List<Permissiongroups> findPermissionNameByPermissionKey(List<String> list)throws Exception;

    /**
     * 获取所有菜单权限
     * @return
     */
    List<Permissiongroups> getAllPermissiongroups();

}
