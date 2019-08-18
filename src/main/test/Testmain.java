import blog.com.entity.Permissiongroups;
import blog.com.entity.SysUser;
import blog.com.serverce.PermissiongroupsService;
import blog.com.serverce.RoleService;
import blog.com.serverce.SysUserService;
import blog.com.serverce.TRolePermissiongroupsService;
import com.alibaba.fastjson.JSON;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2019/8/10.
 */
public class Testmain {
    public static void main(String[] args) throws  Exception{
        ApplicationContext application=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        PermissiongroupsService RoleService= (PermissiongroupsService) application.getBean("permissiongroupsservice");
        List<String> list=new ArrayList<>();
        list.add("000001347989950");
      /*  System.out.println(JSON.toJSON(RoleService.findPermissionNameByPermissionKey(list)));
       */ TRolePermissiongroupsService tRolePermissiongroupsService=(TRolePermissiongroupsService)application.getBean("trolepermissiongroupsservice");
        PermissiongroupsService permissiongroupsService=(PermissiongroupsService)application.getBean("permissiongroupsservice");

        List<String> tRolePermissiongKeyByRoleKeyList =tRolePermissiongroupsService.findTRolePermissiongKeyByRoleKey(list);
        List<Permissiongroups> permissiongroupsList=permissiongroupsService.findPermissionNameByPermissionKey(tRolePermissiongKeyByRoleKeyList);
        System.out.println("输出:"+JSON.toJSON(permissiongroupsList));
    }


}
