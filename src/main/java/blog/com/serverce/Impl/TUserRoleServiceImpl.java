package blog.com.serverce.Impl;

import blog.com.dao.TUserRoleDao;
import blog.com.entity.TUserRole;
import blog.com.serverce.TUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("tuserroleservice")
public class TUserRoleServiceImpl implements TUserRoleService {
    @Autowired
    private TUserRoleDao tUserRoleDao;
    @Override
    public List<String> findRoleIDByUserId(String userId) throws Exception {
        List<String> list=null;
        List<String> roleList=tUserRoleDao.findRoleIDByUserId(userId);
        if (roleList.size()>0){
            return roleList;
        }
        return null;
    }
}
