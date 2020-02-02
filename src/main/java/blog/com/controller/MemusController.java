package blog.com.controller;

import blog.com.blogUtils.UserEnum;
import blog.com.blogUtils.revertMessage;
import blog.com.entity.*;
import blog.com.serverce.PermissiongroupsService;
import blog.com.serverce.SysUserService;
import blog.com.serverce.TRolePermissiongroupsService;
import blog.com.serverce.TUserRoleService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping(value = "/Menu")
@RestController
public class MemusController {
    private static final Logger LOGGER = Logger.getLogger(loginController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TUserRoleService tUserRoleService;
    @Autowired
    private TRolePermissiongroupsService tRolePermissiongroupsService;
    @Autowired
    private PermissiongroupsService permissiongroupsService;
    @RequestMapping(value = "/getAllMenu",method = RequestMethod.GET)

    public String getAllMenu(HttpServletRequest request, HttpServletResponse response){
        //获取用户
        Subject subject= SecurityUtils.getSubject();

        //返回
        revertMessage revertMessage=new revertMessage();
        System.out.println("登陆用户名:"+subject.getPrincipal());
        if (subject.isAuthenticated()){
            if (subject.hasRole(String.valueOf(UserEnum.USER_ROLE.admin)) || subject.hasRole(String.valueOf(UserEnum.USER_ROLE.manager)) || subject.hasRole(String.valueOf(UserEnum.USER_ROLE.user)) && subject.isPermittedAll("user:view")){
            System.out.println("拥有相关权限");
            try {
            List<SysUser> byUname =sysUserService.findByUname((String)subject.getPrincipal(),1,1);
            if (!(byUname.size()>2)){
                    List<String> roleIDByUserId =tUserRoleService.findRoleIDByUserId(byUname.get(0).getSysUserKey());
                    List<String> tRolePermissiongKeyByRoleKey=tRolePermissiongroupsService.findTRolePermissiongKeyByRoleKey(roleIDByUserId);
                    List<Permissiongroups> permissiongroups=permissiongroupsService.findPermissionNameByPermissionKey(tRolePermissiongKeyByRoleKey);
                List<parentMenu> parentMenus=new ArrayList<>();

                    for (Permissiongroups permissiongroups1:permissiongroups
                     ) {
                    parentMenu parentMenu=new parentMenu();

                    if (permissiongroups1.getPermissionFaterNumber().equals("0")){
                        List<childMenu> childMenus=new ArrayList<>();
                    parentMenu.setId(permissiongroups1.getId());
                    parentMenu.setPermissionKey(permissiongroups1.getPermissionKey());
                    parentMenu.setPermissionCode(permissiongroups1.getPermissionCode());
                    parentMenu.setPermissionName(permissiongroups1.getPermissionName());
                    parentMenu.setPermissionFaterNumber(permissiongroups1.getPermissionFaterNumber());
                    parentMenu.setPermissionUrl(permissiongroups1.getPermissionUrl());
                    parentMenu.setPermissionNumber(permissiongroups1.getPermissionNumber());
                        for (Permissiongroups permissiongroups2:permissiongroups
                        ) {
                        if (permissiongroups1.getPermissionKey().equals(permissiongroups2.getPermissionFaterNumber())){
                            childMenu childMenu=new childMenu();
                            childMenu.setId(permissiongroups2.getId());
                            childMenu.setPermissionKey(permissiongroups2.getPermissionKey());
                            childMenu.setPermissionCode(permissiongroups2.getPermissionCode());
                            childMenu.setPermissionName(permissiongroups2.getPermissionName());
                            childMenu.setPermissionFaterNumber(permissiongroups2.getPermissionFaterNumber());
                            /*childMenu.setPermissionSonNumber(permissiongroups2.getPermissionSonNumber());*/
                            childMenu.setPermissionUrl(permissiongroups2.getPermissionUrl());
                            childMenu.setPermissionNumber(permissiongroups2.getPermissionNumber());
                            childMenus.add(childMenu);
                        }
                        }
                        parentMenu.setPermissionSonNumber(childMenus);
                        parentMenus.add(parentMenu);
                    }
                    }
                    return JSON.toJSONString(parentMenus);
            }
            }catch (Exception e){
                LOGGER.error(e.getMessage());
            }
            return JSON.toJSONString(revertMessage);
            }else {
                System.out.println("员工:"+subject.getPrincipal()+"正在尝试登陆系统,但不具备权限基础权限!执行锁定账号!");
                LOGGER.info("员工:"+subject.getPrincipal()+"正在尝试登陆系统,但不具备权限基础权限!执行锁定账号!");
                SysUser sysUser;
                sysUser = new SysUser();
                sysUser.setSysName((String)subject.getPrincipal());
                sysUser.setSysDiscontinuedState("1");
                if (sysUserService.updateByUnameForDiscontinuedState(sysUser)==0){
                    revertMessage.setSessions(subject.getSession().toString());
                    revertMessage.setStatus("500");
                    revertMessage.setMessage("禁用账号错误!出现同名多个用户"+subject.getPrincipal());
                    LOGGER.error("禁用账号错误!出现同名多个用户,该重复用户名:"+subject.getPrincipal());
                    return JSON.toJSONString(revertMessage);
                }else {
                    revertMessage.setSessions("null");
                    revertMessage.setStatus("500");
                    revertMessage.setMessage("禁用账户成功!");
                    return JSON.toJSONString(revertMessage);
                }
            }
        }else {
            revertMessage.setSessions("null");
            revertMessage.setStatus("400");
            revertMessage.setMessage("请登录!");
            return JSON.toJSONString(revertMessage);
        }
    }


}
