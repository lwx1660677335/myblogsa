package blog.com.dao;

import blog.com.entity.SysCustomer;

import java.util.List;

public interface SysCustomerDao {
    /**
     * 查询所有客户信息
     * @return
     */
    List<SysCustomer> getAllCustomer();
}
