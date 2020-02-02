import blog.com.serverce.PermissiongroupsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ccc {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        PermissiongroupsService sysDepartmentService = (PermissiongroupsService) applicationContext.getBean("permissiongroupsservice");

    }
}
