package blog.com.serverce.Impl;

import blog.com.dao.TUserRoleDao;
import blog.com.entity.TUserRole;
import blog.com.serverce.TUserRoleService;
import org.apache.commons.lang.StringUtils;
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

    @Override
    public int addTUserRole(TUserRole tUserRole) {
        if (tUserRole!=null){
            return  tUserRoleDao.addTUserRole(tUserRole);
        }
        return -1;
    }

    @Override
    public int deleteTUserRole(List<String> userid) {
        if (userid.size()!=0&&userid!=null) {
            return tUserRoleDao.deleteTUserRole(userid);
        }
        return -1;
    }
}
