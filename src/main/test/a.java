import blog.com.blogUtils.UUID;
import blog.com.entity.SysUser;
import blog.com.serverce.SysUserService;
import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class a {
    public static UUID UUID= blog.com.blogUtils.UUID.createUUID();
    public static void main(String[] args){
            System.out.println(UUID.getUUID());

    }
}
