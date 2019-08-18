package blog.com.serverce;

import blog.com.entity.Permissiongroups;

import java.util.List;

public interface PermissiongroupsService {
    public List<Permissiongroups> findPermissionNameByPermissionKey(List<String> list)throws Exception;
}
