package blog.com.serverce;

import blog.com.entity.Permissiongroups;
import blog.com.entity.voentity.treeMenuData;

import java.util.List;

public interface PermissiongroupsService {
    public List<Permissiongroups> findPermissionNameByPermissionKey(List<String> list)throws Exception;
    /**
     * 获取所有菜单权限
     * @return
     */
    List<Permissiongroups> getAllPermissiongroups();

    /**
     * 获取菜单栏
     * @param permissiongroups
     * @return
     */
     List<treeMenuData> getTreeMenuData();
}
