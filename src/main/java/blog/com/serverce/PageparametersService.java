package blog.com.serverce;

import blog.com.entity.Pageparameters;
import org.apache.ibatis.annotations.Param;

public interface PageparametersService {
    /**
     * 获取页面参数信息
     * @return
     */
    Pageparameters getPageparmeter(@Param("projectName") String projectName);
}
