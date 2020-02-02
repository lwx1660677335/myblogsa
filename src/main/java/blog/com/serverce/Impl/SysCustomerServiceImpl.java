package blog.com.serverce.Impl;

import blog.com.dao.SysCustomerDao;
import blog.com.entity.SysCustomer;
import blog.com.serverce.SysCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("syscustomerservice")
public class SysCustomerServiceImpl implements SysCustomerService {
    @Autowired
    private SysCustomerDao SysCustomerDao;
    @Override
    public List<SysCustomer> getAllCustomer() {
        List<SysCustomer> SysCustomer=SysCustomerDao.getAllCustomer();
        if (!SysCustomer.isEmpty()){
            return SysCustomer;
        }
        return null;
    }
}
