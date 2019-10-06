package blog.com.realm;

import blog.com.entity.SysUser;
import blog.com.serverce.SysUserService;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends SimpleCredentialsMatcher {
    private static final Logger logger = Logger.getLogger(RetryLimitHashedCredentialsMatcher.class);
    @Autowired
    private SysUserService sysUserService;
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        //获取用户名
        String username = (String)token.getPrincipal();
        //获取用户登录次数
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if (retryCount == null) {
            //如果用户没有登陆过,登陆次数加1 并放入缓存
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {
            //如果用户登陆失败次数大于5次 抛出锁定用户异常  并修改数据库字段
            List<SysUser> user=null;
            try {
                user = sysUserService.findByUname(username,1,1);

            }catch (Exception e){}
            if (user != null && "0".equals(user.get(0).getSysLockedState())&&!(user.size()>0)){
                //数据库字段 默认为 0  就是正常状态 所以 要改为1
                //修改数据库的状态字段为锁定
                user.get(0).setSysLockedState("1");
               int sLockedState=sysUserService.updateByUnameForLockedState(user.get(0));
            }
            logger.info("锁定用户" + user.get(0).getSysName());
            //抛出用户锁定异常
            throw new LockedAccountException();
        }
        //判断用户账号和密码是否正确
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {
            //如果正确,从缓存中将用户登录计数 清除
            passwordRetryCache.remove(username);
        }
        return matches;
    }

    /**
     * 根据用户名 解锁用户
     * @param username
     * @return
     */
    public void unlockAccount(String username){
        List<SysUser> user=null;
        try {
            user = sysUserService.findByUname(username,1,1);
        }catch (Exception e){}
        if (user != null&&!(user.size()>0)){
            //修改数据库的状态字段为锁定
            user.get(0).setSysLockedState("0");
            /*userMapper.update(user);*/
            int lockedstate=sysUserService.updateByUnameForLockedState(user.get(0));
            passwordRetryCache.remove(username);
        }
    }
}
