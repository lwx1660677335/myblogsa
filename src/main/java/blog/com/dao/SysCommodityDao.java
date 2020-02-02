package blog.com.dao;

import blog.com.entity.SysCommodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysCommodityDao {
    /**
     * 获取所有商品
     * @return
     */
    List<SysCommodity> getAllSysCommoditys();

    /**
     * 根据商品名获取商品
     * @param sysCommodityName
     * @return
     */
    List<SysCommodity> getSysCommoditysbyName(@Param("sysCommodityName") String sysCommodityName);
}
