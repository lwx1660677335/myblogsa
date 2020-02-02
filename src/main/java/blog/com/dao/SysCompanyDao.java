package blog.com.dao;

import blog.com.entity.SysCompany;

import java.util.List;

public interface SysCompanyDao {
    /**
     * 查询所有单位
     * @return
     */
    List<SysCompany> getAllCompany();
}
