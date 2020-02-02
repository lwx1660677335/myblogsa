package blog.com.controller;

import blog.com.blogUtils.UserEnum;
import blog.com.blogUtils.layerData;
import blog.com.entity.SysCommodity;
import blog.com.entity.SysUser;
import blog.com.serverce.SysCommodityService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import blog.com.blogUtils.revertMessage;

@RestController
@RequestMapping("/get")
public class SysCommodityController {
    @Autowired
    private SysCommodityService SysCommodityService;

    @RequestMapping(value = "Allcommodity", method = RequestMethod.GET)
    public String Allcommodity(HttpServletRequest HttpServletRequest, HttpServletResponse HttpServletResponse) {
        layerData layerData = new layerData();
        if (StringUtils.isNotBlank(HttpServletRequest.getParameter("page")) && StringUtils.isNotBlank(HttpServletRequest.getParameter("limit"))) {
            List<SysCommodity> SysCommodity = SysCommodityService.getAllSysCommoditys(Integer.valueOf(HttpServletRequest.getParameter(UserEnum.PAGE_PARPA.page.toString())), Integer.valueOf(HttpServletRequest.getParameter(UserEnum.PAGE_PARPA.limit.toString())));
            if (!SysCommodity.isEmpty()) {
                for (SysCommodity sysCommodity:SysCommodity
                     ) {
                    sysCommodity.setSupplierId(sysCommodity.getSysCustomer().getCustomerName());
                    sysCommodity.setCommodityCompany(sysCommodity.getSysCompany().getCompanyName());
                }
                layerData.setStatus(Integer.valueOf(0));
                layerData.setCount(SysCommodity.size());
                layerData.setMessage("返回成功!");
                layerData.setData(SysCommodity);
                return JSON.toJSONString(layerData);
            } else {
                return JSON.toJSONString(layerData);
            }
        }
        return JSON.toJSONString(layerData);
    }
}
