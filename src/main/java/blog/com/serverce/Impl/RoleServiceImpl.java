package blog.com.serverce.Impl;

import blog.com.dao.RoleDao;
import blog.com.entity.Role;
import blog.com.serverce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("roleservice")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findRoleNameByPowerID(List<String> powerId) throws Exception {
        List<Role> roles=roleDao.findRoleNameByPowerID(powerId);
        if (roles.size()>0){
            return roles;
        }else {
            return null;
        }
    }

    @Override
    public List<Role> getAllRole() {
        List<Role> roleList=roleDao.getAllRole();
        return roleList.size()!=0&&roleList!=null?roleList:null;
    }
}
