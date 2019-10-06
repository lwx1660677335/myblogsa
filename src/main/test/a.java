import blog.com.blogUtils.UUID;
import blog.com.entity.Permissiongroups;
import blog.com.entity.SysUser;
import blog.com.serverce.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class a {
    public static UUID UUID = blog.com.blogUtils.UUID.createUUID();
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TUserRoleService tUserRoleService;
    @Autowired
    private TRolePermissiongroupsService tRolePermissiongroupsService;
    @Autowired
    private PermissiongroupsService permissiongroupsService;
    public static void main(String[] args)   {

        ApplicationContext application=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        SysUserService sysUserService= (SysUserService) application.getBean("sysuserservice");
        PermissiongroupsService permissiongroupsService= (PermissiongroupsService) application.getBean("permissiongroupsservice");
        RoleService roleService= (RoleService) application.getBean("roleservice");
        TRolePermissiongroupsService tRolePermissiongroupsService= (TRolePermissiongroupsService) application.getBean("trolepermissiongroupsservice");
        TUserRoleService tUserRoleService= (TUserRoleService) application.getBean("tuserroleservice");
        /*SysUser sysUser=new SysUser();
        sysUser.setSysName("李四");
        sysUser.setSysLockedState("1");
        int state=sysUserService.updateByUnameForLockedState(sysUser);
        System.out.println(JSON.toJSONString(state));*/
         /*   System.out.println(UUID.getUUID());*/
        try {
            long starttime=0;
            System.out.println(starttime=System.currentTimeMillis());
            List<SysUser> byUname =sysUserService.findByUname("李四",1,1);
            List<String> roleIDByUserId =tUserRoleService.findRoleIDByUserId(byUname.get(0).getSysUserKey());
            List<String> tRolePermissiongKeyByRoleKey=tRolePermissiongroupsService.findTRolePermissiongKeyByRoleKey(roleIDByUserId);
            List<Permissiongroups> permissiongroups=permissiongroupsService.findPermissionNameByPermissionKey(tRolePermissiongKeyByRoleKey);
            System.out.println((System.currentTimeMillis()-starttime)/1000+"MS");
            System.out.println(JSON.toJSONString(permissiongroups.size()));
        }catch (Exception e){

        }

    }
}
