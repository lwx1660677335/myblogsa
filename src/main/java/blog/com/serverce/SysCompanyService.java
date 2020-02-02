package blog.com.serverce;

import blog.com.entity.SysCompany;

import java.util.List;

public interface SysCompanyService {
    /**
     * 查询所有单位
     * @return
     */
    List<SysCompany> getAllCompany();
}
