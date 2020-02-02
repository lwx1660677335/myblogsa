package blog.com.controller;

import blog.com.blogUtils.*;
import blog.com.entity.SysUser;
import blog.com.entity.TUserRole;
import blog.com.serverce.PageparametersService;
import blog.com.serverce.SysUserService;
import blog.com.serverce.TUserRoleService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/get")
public class userController {
    private static final Logger LOGGER = Logger.getLogger(userController.class);
    private final static UUID uuid = UUID.getUUID();
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private PageparametersService pageparametersService;
    @Autowired
    private TUserRoleService tUserRoleService;

    /**
     * 获取所有用户
     *
     * @param request  获取页数,数量
     * @param response
     * @return 返回所有用户
     */
    @RequestMapping(value = "AllUser", method = RequestMethod.GET)
    @ResponseBody
    public String AllUser(HttpServletRequest request, HttpServletResponse response) {
        /*revertMessage revertMessage=new revertMessage();*/
        layerData revertMessage = new layerData();
        /*  Pageparameters pageparameters =pageparametersService.getPageparmeter("人员信息显示");*/
        try {
            if (StringUtils.isNotBlank(request.getParameter("page")) && StringUtils.isNotBlank(request.getParameter("limit"))) {
                List<SysUser> sysUsers = sysUserService.AllUser(Integer.valueOf(request.getParameter(UserEnum.PAGE_PARPA.page.toString())), Integer.valueOf(request.getParameter(UserEnum.PAGE_PARPA.limit.toString())));
                if (sysUsers.size() > 0) {
                    revertMessage.setStatus(Integer.valueOf(0));
                    revertMessage.setCount(sysUsers.size());
                    revertMessage.setMessage("返回成功!");
                    revertMessage.setData(sysUsers);
                    return JSON.toJSONString(revertMessage);
                }
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return JSON.toJSONString(revertMessage);
        }
        return JSON.toJSONString(revertMessage);
    }

    /**
     * 添加用户信息
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    @ResponseBody
    public String addUser(HttpServletRequest request, HttpServletResponse response) {
        revertMessage revertMessage = new revertMessage();
        String Key=null;
        TimeUtils timeUtils = new TimeUtils();
        TUserRole tUserRole = new TUserRole();
        tUserRole.setIdKey(uuid.createUUID());
        tUserRole.setUserId(Key=uuid.createUUID());
        tUserRole.setRoleId(request.getParameter("sysrole").trim());
        int num = tUserRoleService.addTUserRole(tUserRole);
        SysUser sysUser = new SysUser();
        sysUser.setSysUserKey(uuid.createUUID());
        sysUser.setSysCreteTime(timeUtils.getTimestamp());
        sysUser.setSysEndTime(timeUtils.getTimestamp());
        sysUser.setSysName(StringUtils.isNotEmpty(request.getParameter("username")) ? request.getParameter("username") : null);
        sysUser.setSysPassword(StringUtils.isNotEmpty(request.getParameter("password")) ? request.getParameter("password") : null);
        sysUser.setSystelepthone(StringUtils.isNotEmpty(request.getParameter("systelepthone")) ? request.getParameter("systelepthone") : null);
        sysUser.setSysdepartment(StringUtils.isNotEmpty(request.getParameter("sysdepartment")) ? request.getParameter("sysdepartment") : null);
        sysUser.setSysAdminPower(Key!=null&&StringUtils.isNotEmpty(Key) ? Key : null);
        sysUser.setSysadress(StringUtils.isNotEmpty(request.getParameter("sysadress")) ? request.getParameter("sysadress") : null);
        sysUser.setSysDiscontinuedState(StringUtils.isNotEmpty(request.getParameter("sysdiscontinuedstate")) ? request.getParameter("sysdiscontinuedstate") : null);
        sysUser.setSysspanned(StringUtils.isNotEmpty(request.getParameter("sysspanned")) ? request.getParameter("sysspanned") : null);
        sysUser.setSysaccess(StringUtils.isNotEmpty(request.getParameter("sysaccess")) ? request.getParameter("sysaccess") : null);
        sysUser.setSysgender(StringUtils.isNotEmpty(request.getParameter("sex")) ? request.getParameter("sex") : null);
        try {
            if (Key!=null&&StringUtils.isNotEmpty(Key)){
            if (sysUserService.addUser(sysUser) >= 1) {

                revertMessage.setId(200);
                revertMessage.setStatus("200");
                revertMessage.setMessage("添加用户成功");
                return JSON.toJSONString(revertMessage);
            } else {
                revertMessage.setId(500);
                revertMessage.setStatus("500");
                revertMessage.setMessage("添加用户失败");
                return JSON.toJSONString(revertMessage);
            }

            }
        } catch (Exception e) {
            revertMessage.setMessage(e.getMessage());
            return JSON.toJSONString(revertMessage);

        }
        return JSON.toJSONString(revertMessage);
    }

    @RequestMapping(value = "deleteUsers", method = RequestMethod.GET)
    @ResponseBody
    public String deleteUsers(String[] datas, HttpServletRequest request, HttpServletResponse response) {
        String[] ids = request.getParameterValues("datas");
        revertMessage revertMessage = new revertMessage();
        List<String> list = Arrays.asList(ids);
        for (String s : list
        ) {
            System.out.println(s);
        }
        List<SysUser> sysUsers = sysUserService.findByUserKey(list);
        List<String> SysAdminPower = new ArrayList<>();
        if (sysUsers != null && !sysUsers.isEmpty()) {
            for (SysUser user : sysUsers
            ) {
                SysAdminPower.add(user.getSysAdminPower());
            }
        }
        if (SysAdminPower != null && !SysAdminPower.isEmpty()) {
            int stats=tUserRoleService.deleteTUserRole(SysAdminPower);
            if ( stats> 0) {
                if (sysUserService.deleteUsers(list) == ids.length) {
                    revertMessage.setId(200);
                    revertMessage.setMessage("删除成功!");
                    revertMessage.setStatus("200");
                    return JSON.toJSONString(revertMessage);
                } else {
                    revertMessage.setId(500);
                    revertMessage.setStatus("500");
                    revertMessage.setMessage("删除失败!");
                    return JSON.toJSONString(revertMessage);
                }
            }else if (stats==0){
                if (sysUserService.deleteUsers(list) == ids.length){
                    revertMessage.setId(200);
                    revertMessage.setMessage("删除成功!");
                    revertMessage.setStatus("200");
                    return JSON.toJSONString(revertMessage);
                }
            }
        }
        return JSON.toJSONString(revertMessage);
    }
    @RequestMapping(value = "UpdateUser",method = RequestMethod.GET)
    @ResponseBody
    public String UpdateUser(HttpServletRequest request,HttpServletResponse response){
        revertMessage revertMessage=new revertMessage();
       /* String Key=null;
        TimeUtils timeUtils = new TimeUtils();
        TUserRole tUserRole = new TUserRole();
        tUserRole.setIdKey(uuid.createUUID());
        tUserRole.setUserId(Key=uuid.createUUID());
        tUserRole.setRoleId(request.getParameter("sysrole").trim());
        int num = tUserRoleService.addTUserRole(tUserRole);
        SysUser sysUser = new SysUser();
        sysUser.setSysUserKey(uuid.createUUID());
        sysUser.setSysCreteTime(timeUtils.getTimestamp());
        sysUser.setSysEndTime(timeUtils.getTimestamp());
        sysUser.setSysName(StringUtils.isNotEmpty(request.getParameter("username")) ? request.getParameter("username") : null);
        sysUser.setSysPassword(StringUtils.isNotEmpty(request.getParameter("password")) ? request.getParameter("password") : null);
        sysUser.setSystelepthone(StringUtils.isNotEmpty(request.getParameter("systelepthone")) ? request.getParameter("systelepthone") : null);
        sysUser.setSysdepartment(StringUtils.isNotEmpty(request.getParameter("sysdepartment")) ? request.getParameter("sysdepartment") : null);
        sysUser.setSysAdminPower(Key!=null&&StringUtils.isNotEmpty(Key) ? Key : null);
        sysUser.setSysadress(StringUtils.isNotEmpty(request.getParameter("sysadress")) ? request.getParameter("sysadress") : null);
        sysUser.setSysDiscontinuedState(StringUtils.isNotEmpty(request.getParameter("sysdiscontinuedstate")) ? request.getParameter("sysdiscontinuedstate") : null);
        sysUser.setSysspanned(StringUtils.isNotEmpty(request.getParameter("sysspanned")) ? request.getParameter("sysspanned") : null);
        sysUser.setSysaccess(StringUtils.isNotEmpty(request.getParameter("sysaccess")) ? request.getParameter("sysaccess") : null);
        sysUser.setSysgender(StringUtils.isNotEmpty(request.getParameter("sex")) ? request.getParameter("sex") : null);
        try {
            if (Key!=null&&StringUtils.isNotEmpty(Key)){
                if (sysUserService.addUser(sysUser) >= 1) {

                    revertMessage.setId(200);
                    revertMessage.setStatus("200");
                    revertMessage.setMessage("添加用户成功");
                    return JSON.toJSONString(revertMessage);
                } else {
                    revertMessage.setId(500);
                    revertMessage.setStatus("500");
                    revertMessage.setMessage("添加用户失败");
                    return JSON.toJSONString(revertMessage);
                }

            }
        } catch (Exception e) {
            revertMessage.setMessage(e.getMessage());
            return JSON.toJSONString(revertMessage);

        }*/
        return JSON.toJSONString(revertMessage);
    }
    @RequestMapping(name = "serchUser",value = "serchUser",method =RequestMethod.GET )
    public String serchUser(){
        return "";
    }

}
