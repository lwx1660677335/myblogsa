package blog.com.serverce.Impl;

import blog.com.dao.SysUserDao;
import blog.com.entity.SysUser;
import blog.com.serverce.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sysuserservice")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Override
    public List<SysUser> findByUname(String name, int pageNum, int pageSize) throws  Exception {
        if (name!=null){
            PageHelper.startPage(pageNum,pageSize);
            List<SysUser> sysUser = sysUserDao.findByUname(name);
            PageInfo<SysUser> listPageInfo=new PageInfo<>(sysUser);
            return listPageInfo.getList();
        }
        return null;
    }
}
