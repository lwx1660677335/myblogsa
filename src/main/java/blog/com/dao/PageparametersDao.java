package blog.com.dao;

import blog.com.entity.Pageparameters;
import org.apache.ibatis.annotations.Param;

public interface PageparametersDao {
    /**
     * 获取页面参数信息
     * @return
     */
    Pageparameters getPageparmeter(@Param("projectName") String projectName);
}
