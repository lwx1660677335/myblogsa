package blog.com.dao;

import blog.com.entity.SysDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDepartmentDao {
    /**
     * 根据ID查询部门名称
     * @param departmentid
     * @return
     */
    List<SysDepartment> getDepartment(List<String> departmentid);

    /**
     * 获取所有部门信息
     * @return
     */
    List<SysDepartment> getAllDepartment();
    /**
     * 获取一条部门数据
     * @param departmentid
     * @return
     */
    SysDepartment getDepartmentOne(@Param("departmentid") String departmentid);

    /**
     * 添加部门数据
     * @param sysDepartments
     * @return
     */
    int addDepartment(List<SysDepartment> sysDepartments);

    /**
     * 根据ID删除一条删除
     * @param departmentid
     * @return
     */
    int removeDepartment(@Param("departmentid") String departmentid);

}
