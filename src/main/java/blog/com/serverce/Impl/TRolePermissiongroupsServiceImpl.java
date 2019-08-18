package blog.com.serverce.Impl;

import blog.com.dao.TRolePermissiongroupsDao;
import blog.com.serverce.TRolePermissiongroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("trolepermissiongroupsservice")
public class TRolePermissiongroupsServiceImpl implements TRolePermissiongroupsService {
    @Autowired
    private TRolePermissiongroupsDao tRolePermissiongroupsDao;
    @Override
    public List<String> findTRolePermissiongKeyByRoleKey(List<String> list) throws Exception {
        List<String> strings=null;
        List<String> list1=tRolePermissiongroupsDao.findTRolePermissiongKeyByRoleKey(list);
        if (list1.size()>0){
            return list1;
        }else {
            return null;
        }
    }
}
