import blog.com.blogUtils.UUID;
import blog.com.entity.Permissiongroups;
import blog.com.entity.SysCommodity;
import blog.com.entity.SysUser;
import blog.com.serverce.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class a {
    /*public static UUID UUID = UUID.getUUID();*/
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
        SysCommodityService sysUserService= (SysCommodityService) application.getBean("syscommodityservice");
        try{
            List<SysCommodity> SysUser=sysUserService.getAllSysCommoditys(1,10);
            System.out.println(JSON.toJSON(SysUser));
        }catch (Exception e){

        }
        /*SysUser sysUser=new SysUser();
        sysUser.setSysName("李四");
        sysUser.setSysLockedState("1");
        int state=sysUserService.updateByUnameForLockedState(sysUser);
        System.out.println(JSON.toJSONString(state));*/
         /*   System.out.println(UUID.getUUID());*/
//        try {
//            List<String> list=new ArrayList<>();
//            list.add("33312");
//            long starttime=0;
//            int num=sysUserService.deleteUsers(list);
//            System.out.println(JSON.toJSONString(num));
//        }catch (Exception e){
//        System.out.println(e.getMessage());
//        }

    }
}
