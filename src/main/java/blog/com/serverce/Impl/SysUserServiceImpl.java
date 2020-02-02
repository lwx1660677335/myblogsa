package blog.com.serverce.Impl;

import blog.com.dao.SysUserDao;
import blog.com.entity.SysUser;
import blog.com.serverce.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.cache.TransactionalCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service("sysuserservice")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;


    @Override
    public List<SysUser> findByUname(String name, int pageNum, int pageSize) throws Exception {
        if (name != null) {
            PageHelper.startPage(pageNum, pageSize);
            List<SysUser> sysUser = sysUserDao.findByUname(name);
            PageInfo<SysUser> listPageInfo = new PageInfo<>(sysUser);
            return listPageInfo.getList();
        }
        return null;
    }

    /***
     * 修改锁定状态如果返回大于0那么修改成功,小于0修改失败
     * @param sysUser
     * @return 0or 0>
     */
    @Override
    public int updateByUnameForLockedState(SysUser sysUser) {
        if (null != sysUser.getSysName() && !(sysUser.getSysName().equals("")) && null != sysUser.getSysLockedState() && !(sysUser.getSysLockedState().equals(""))) {
            return sysUserDao.updateByUnameForLockedState(sysUser);
        }
        return 0;
    }

    @Override
    public int updateByUnameForDiscontinuedState(SysUser SysUser) {
        int number=0;
        if (StringUtils.isNotBlank(SysUser.getSysDiscontinuedState())&&StringUtils.isNotBlank(SysUser.getSysName()))
        {
            /**
             * 如果修改出现2大于2条数据那么回滚事物返回错误处理
             */
            if (sysUserDao.updateByUnameForDiscontinuedState(SysUser)>2){
                return number;
            }else {
                return number=sysUserDao.updateByUnameForDiscontinuedState(SysUser);
            }
        }
            return number;
    }
@Override
    public List<SysUser> AllUser(int pageNum,int pageSize) {
            PageHelper.startPage(pageNum, pageSize);
            List<SysUser> sysUser = sysUserDao.AllUser();
            PageInfo<SysUser> listPageInfo = new PageInfo<>(sysUser);
            return listPageInfo.getList();
    }

    @Override
    public int addUser(SysUser sysUser) {
        if (sysUser!=null){
            return sysUserDao.addUser(sysUser);
        }
        return 0;
    }

    @Override
    public int updateUser(SysUser sysUser) {
        if (sysUser!=null){
            return sysUserDao.updateUser(sysUser);
        }
        return 0;
    }

    @Override
    public List<SysUser> findByUserKey(List<String> userid) {
        if (userid!=null&&!userid.isEmpty()){
            return sysUserDao.findByUserKey(userid);
        }
        return null;
    }

    @Override
    public int deleteUsers(List<String> userid) {
        if (userid!=null&&!userid.isEmpty()){
            return sysUserDao.deleteUsers(userid);
        }
        return -1;
    }
}
