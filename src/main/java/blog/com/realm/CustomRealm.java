package blog.com.realm;

import blog.com.Exception.AccountException;
import blog.com.entity.Permissiongroups;
import blog.com.entity.Role;
import blog.com.entity.TUserRole;
import blog.com.serverce.*;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import blog.com.entity.SysUser;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomRealm extends AuthorizingRealm {
    private final static Logger LOGGER = Logger.getLogger(CustomRealm.class);
    private int SeeionSize = -1;
    @Autowired
    private SessionDAO sessionDAO;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private TUserRoleService tUserRoleService;
    @Autowired
    private TRolePermissiongroupsService tRolePermissiongroupsService;
    @Autowired
    private PermissiongroupsService permissiongroupsService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) super.getAvailablePrincipal(principalCollection);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        System.out.println("值：" + username);
        if (StringUtils.isNotBlank(username)) {
            try {
                List<SysUser> sysUsers = sysUserService.findByUname(username, 1, 1);
                List<String> tUserRoles = tUserRoleService.findRoleIDByUserId(sysUsers.get(0).getSysAdminPower());
                List<String> list = new ArrayList<>();
               /* for (TUserRole list1 : tUserRoles) {
                    if (StringUtils.isNotBlank(list1.getRoleId())) {
                        list.add(list1.getRoleId());
                    }
                }*/
                List<Role> roles = roleService.findRoleNameByPowerID(tUserRoles);
                List<String> tRolePermissiongKeyByRoleKeyList = tRolePermissiongroupsService.findTRolePermissiongKeyByRoleKey(tUserRoles);
                for (String s : tRolePermissiongKeyByRoleKeyList
                ) {
                    if (StringUtils.isBlank(s)) {
                        tRolePermissiongKeyByRoleKeyList.remove(s);
                    }
                }
                List<Permissiongroups> permissiongroupsList = permissiongroupsService.findPermissionNameByPermissionKey(tRolePermissiongKeyByRoleKeyList);
                for (Role role : roles
                ) {
                    info.addRole(role.getRolename());
                }
                for (Permissiongroups permissiongroups : permissiongroupsList) {
                    info.addStringPermission(permissiongroups.getPermissionCode());
                }
                return info;
            }catch (AuthenticationException e){
                throw e instanceof UnknownAccountException?new UnknownAccountException():e;
            }catch (Exception e) {
                System.out.println("权限效验:"+e.getMessage());
                LOGGER.error(e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("当前用户：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        List<SysUser> sysUsers = null;
        try {
            if (StringUtils.isNotBlank(token.getUsername())) {
                sysUsers = sysUserService.findByUname(token.getUsername(), 1, 1);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        if (sysUsers.size() >= 2) {
            LOGGER.error("请联系管理员,出现重复数据");
            throw new AccountException("请联系管理员,出现重复数据");
        }
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        System.out.println("seesion个数：" + sessions.size());
        for (Session session : sessions) {
            System.out.println("seesionID:" + session.getId());
            System.out.println("登录ip:" + session.getHost());
            System.out.println("登录用户" + session.getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY));
            System.out.println("最后操作日期:" + session.getLastAccessTime());
        }
        if ("1".equals(sysUsers.get(0).getSysLockedState())) {
            throw new LockedAccountException();
        } else if ("1".equals(sysUsers.get(0).getSysDiscontinuedState())) {
            throw new DisabledAccountException();
        } else if (!(sysUsers.size() == 0)&&!("1".equals(sysUsers.get(0).getSysLockedState()))&&!("1".equals(sysUsers.get(0).getSysDiscontinuedState()))) {
            return new SimpleAuthenticationInfo(sysUsers.get(0).getSysName(), sysUsers.get(0).getSysPassword(), "a");
        }
        return null;
    }

    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}



