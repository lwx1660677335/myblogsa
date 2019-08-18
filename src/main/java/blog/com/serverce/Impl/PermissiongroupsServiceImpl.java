package blog.com.serverce.Impl;

import blog.com.dao.PermissiongroupsDao;
import blog.com.entity.Permissiongroups;
import blog.com.serverce.PermissiongroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("permissiongroupsservice")
public class PermissiongroupsServiceImpl implements PermissiongroupsService {
    @Autowired
    private PermissiongroupsDao permissiongroupsDao;
    @Override
    public List<Permissiongroups> findPermissionNameByPermissionKey(List<String> list) throws Exception {
        List<Permissiongroups> permissiongroups=null;
        List<Permissiongroups> permissiongroupsList=permissiongroupsDao.findPermissionNameByPermissionKey(list);
        if (permissiongroupsList.size()>0){
            return permissiongroupsList;
        }else {
            return permissiongroups;
        }
    }
}
