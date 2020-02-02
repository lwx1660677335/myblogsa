package blog.com.serverce;

import blog.com.entity.SysCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysCommodityService {
    /**
     * 获取所有商品
     * @param page
     * @param size
     * @return
     */
    List<SysCommodity> getAllSysCommoditys(int page, int size);

    /**
     * 根据商品名获取商品
     * @param sysCommodityName
     * @param page
     * @param size
     * @return
     */
    List<SysCommodity> getSysCommoditysbyName(@Param("sysCommodityName") String sysCommodityName, int page, int size);
}
