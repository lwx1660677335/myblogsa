package blog.com.serverce.Impl;

import blog.com.dao.SysCompanyDao;
import blog.com.entity.SysCompany;
import blog.com.serverce.SysCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("syscompanyservice")
public class SysCompanyServiceImpl implements SysCompanyService {
@Autowired
private SysCompanyDao SysCompanyDao;
    @Override
    public List<SysCompany> getAllCompany() {
        List<SysCompany> SysCompany=SysCompanyDao.getAllCompany();
        if (!SysCompany.isEmpty()){
            return SysCompany;
        }
        return null;
    }
}
