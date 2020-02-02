package blog.com.serverce;

import blog.com.entity.SysCustomer;

import java.util.List;

public interface SysCustomerService {
    /**
     * 查询所有客户信息
     * @return
     */
    List<SysCustomer> getAllCustomer();
}
