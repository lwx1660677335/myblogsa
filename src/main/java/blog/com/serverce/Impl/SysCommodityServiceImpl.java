package blog.com.serverce.Impl;

import blog.com.dao.SysCommodityDao;
import blog.com.entity.SysCommodity;
import blog.com.serverce.SysCommodityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("syscommodityservice")
public class SysCommodityServiceImpl implements SysCommodityService {
    @Autowired
    private SysCommodityDao SysCommodityDao;
    @Override
    public List<SysCommodity> getAllSysCommoditys(int page, int size) {
        PageHelper.startPage(page, size);
        List<SysCommodity> SysCommodity=SysCommodityDao.getAllSysCommoditys();
        PageInfo<SysCommodity> SysCommoditypage=null;
        if (!SysCommodity.isEmpty()){
         SysCommoditypage=new PageInfo<>(SysCommodity);
        }
        return SysCommoditypage!=null?SysCommoditypage.getList():null;
    }

    @Override
    public List<SysCommodity> getSysCommoditysbyName(String sysCommodityName, int page, int size) {
        PageHelper.startPage(page, size);
        List<SysCommodity> SysCommodity=SysCommodityDao.getSysCommoditysbyName(sysCommodityName);
        PageInfo<SysCommodity> SysCommoditypage=null;
        if (!SysCommodity.isEmpty()){
            SysCommoditypage=new PageInfo<>(SysCommodity);
        }
        return SysCommoditypage!=null?SysCommoditypage.getList():null;
    }
}
