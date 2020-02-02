package blog.com.serverce.Impl;

import blog.com.dao.SysDepartmentDao;
import blog.com.entity.SysDepartment;
import blog.com.serverce.SysDepartmentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("syssepartmentservice")
public class SysDepartmentServiceImpl implements SysDepartmentService {
    @Autowired
    private SysDepartmentDao sysDepartmentDao;
    @Override
    public List<SysDepartment> getDepartment(List<String> departmentid) {
        if (departmentid.size()!=0&& departmentid!=null){
            return sysDepartmentDao.getDepartment(departmentid);
        }
        return null;
    }

    @Override
    public List<SysDepartment> getAllDepartment() {
        List<SysDepartment> allDepartment=sysDepartmentDao.getAllDepartment();
        return allDepartment.size()!=0&&allDepartment!=null?allDepartment:null;
    }

    @Override
    public SysDepartment getDepartmentOne(String departmentid) {
        if (StringUtils.isNotBlank(departmentid)){
            return sysDepartmentDao.getDepartmentOne(departmentid);
        }
        return null;
    }

    @Override
    public int addDepartment(List<SysDepartment> sysDepartments) {
        if (sysDepartments.size()!=0&& sysDepartments!=null){
            return sysDepartmentDao.addDepartment(sysDepartments);
        }
        return 0;
    }

    @Override
    public int removeDepartment(String departmentid) {
        if (StringUtils.isNotBlank(departmentid)){
            return sysDepartmentDao.removeDepartment(departmentid);
        }
        return 0;
    }
}
