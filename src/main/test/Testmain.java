import blog.com.entity.Permissiongroups;
import blog.com.entity.SysUser;
import blog.com.serverce.PermissiongroupsService;
import blog.com.serverce.SysDepartmentService;
import blog.com.serverce.SysUserService;
import blog.com.serverce.TRolePermissiongroupsService;
import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mo on 2019/8/10.
 */
public class Testmain {
    public static void main(String[] args) throws  Exception{
        ApplicationContext application=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        SysUserService sysUserService= (SysUserService) application.getBean("sysuserservice");
        /*List<String> list=new ArrayList<>();
        list.add("000001347989950");*/
        Date date=new Date();
        Timestamp timestamp=new Timestamp(date.getTime());

        SysUser sysUser=new SysUser();
        sysUser.setSysUserKey(null);
        sysUser.setSysName("网上");
        sysUser.setSysPassword("0");
        sysUser.setSysgender("男");
        sysUser.setSysCreteTime(timestamp);
        sysUser.setSysEndTime(timestamp);
        sysUser.setSysCorrespondingPower(Long.valueOf("0"));
        sysUser.setSysPowerStart("0");
        sysUser.setSysAdminStart("0");
        sysUser.setSysAdminPower("0");
        sysUser.setSysDiscontinuedState("0");
        sysUser.setSysLockedState("0");
        sysUser.setSysdepartment("201910071129");
        sysUser.setSystelepthone("1231231");
        sysUser.setSysadress("郫县团结");
        sysUser.setSysaccess("0");
        sysUser.setSysspanned("0");


        System.out.println("输出:"+JSON.toJSON(sysUserService.addUser(sysUser)));
    }



}
