package blog.com.controller;

import blog.com.blogUtils.UserEnum;
import blog.com.blogUtils.layerData;
import blog.com.entity.Pageparameters;
import blog.com.entity.SysUser;
import blog.com.serverce.PageparametersService;
import blog.com.serverce.SysUserService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/get")
public class userController {
    private static final Logger LOGGER=Logger.getLogger(userController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PageparametersService pageparametersService;

    /**
     * 获取所有用户
     * @param request 获取页数,数量
     * @param response
     * @return 返回所有用户
     */
    @RequestMapping(value = "AllUser",method = RequestMethod.GET)
    @ResponseBody
    public String AllUser(HttpServletRequest request, HttpServletResponse response){
        /*revertMessage revertMessage=new revertMessage();*/
        layerData revertMessage=new layerData();
      /*  Pageparameters pageparameters =pageparametersService.getPageparmeter("人员信息显示");*/
        try {
        if (StringUtils.isNotBlank(request.getParameter(UserEnum.PAGE_PARPA.page.toString()))&&StringUtils.isNotBlank(request.getParameter(UserEnum.PAGE_PARPA.limit.toString()))){
            List<SysUser> sysUsers =sysUserService.AllUser(Integer.valueOf(request.getParameter(UserEnum.PAGE_PARPA.page.toString())),Integer.valueOf(request.getParameter(UserEnum.PAGE_PARPA.limit.toString())));
            if (sysUsers.size()>0)
            {
                revertMessage.setStatus(Integer.valueOf(0));
                revertMessage.setCount(sysUsers.size());
                revertMessage.setMessage("返回成功!");
                revertMessage.setData(sysUsers);
                return JSON.toJSONString(revertMessage);
            }
        }
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return JSON.toJSONString(revertMessage);
        }
        return JSON.toJSONString(revertMessage);
    }
}
