import blog.com.entity.SysDepartment;
import blog.com.entity.TUserRole;
import blog.com.entity.voentity.treeMenuData;
import blog.com.serverce.PermissiongroupsService;
import blog.com.serverce.SysDepartmentService;
import blog.com.serverce.TUserRoleService;
import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class syssepartmenttest {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TUserRoleService tUserRoleService = (TUserRoleService) applicationContext.getBean("tuserroleservice");
        /*List<SysDepartment> strings=new ArrayList<>();
        SysDepartment sysDepartment=new SysDepartment();
        sysDepartment.setId("201910011820");
        sysDepartment.setDepartmentName("企划部");
        strings.add(sysDepartment);*/
        TUserRole tUserRole=new TUserRole();
        tUserRole.setIdKey("12313123aa1");
        tUserRole.setRoleId("12312");
        tUserRole.setUserId("adasdasd");

        int sysDepartments=tUserRoleService.addTUserRole(tUserRole);
        System.out.print(JSON.toJSON(sysDepartments));
    }
}
