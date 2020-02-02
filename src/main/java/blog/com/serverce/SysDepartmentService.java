package blog.com.serverce;

import blog.com.entity.SysDepartment;

import java.util.List;

public interface SysDepartmentService {
        /**
         * 根据ID查询部门名称
         * @param departmentid
         * @return
         */
        List<SysDepartment> getDepartment(List<String> departmentid);

        /**
         * 查询所有部门
         * @return
         */
        List<SysDepartment> getAllDepartment();

        /**
         * 获取一条部门数据
         * @param departmentid
         * @return
         */
        SysDepartment getDepartmentOne(String departmentid);

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
        int removeDepartment(String departmentid);

    }
