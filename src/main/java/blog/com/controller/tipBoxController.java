package blog.com.controller;

import blog.com.entity.*;
import blog.com.entity.voentity.tipboxInit;
import blog.com.entity.voentity.tipboxInitCommodity;
import blog.com.entity.voentity.treeMenuData;
import blog.com.serverce.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/tipbox")
public class tipBoxController {
    @Autowired
    private SysDepartmentService sysDepartmentService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissiongroupsService permissiongroupsService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysCompanyService SysCompanyService;
    @Autowired
    private SysCustomerService SysCustomerService;

    @RequestMapping(value = "getInitParme", method = RequestMethod.GET)
    @ResponseBody
    public String getInitParme(HttpServletRequest request, HttpServletResponse response) {
        tipboxInit tipboxInit = new tipboxInit();
        //获取所有部门
        List<SysDepartment> allDepartment = sysDepartmentService.getAllDepartment();
        //获取所有角色
        List<Role> roles = roleService.getAllRole();
        //获取所有菜单栏
        List<treeMenuData> treeMenuData = permissiongroupsService.getTreeMenuData();
        if (!allDepartment.isEmpty() & !roles.isEmpty() & !treeMenuData.isEmpty()) {

            tipboxInit.setRoles(roles);
            tipboxInit.setSysDepartments(allDepartment);
            tipboxInit.setTreeMenuDatas(treeMenuData);
            tipboxInit.setStatus("200");
            tipboxInit.setMessage("返回成功!");
            return JSON.toJSONString(tipboxInit);
        }
        return JSON.toJSONString(tipboxInit);
    }

    @RequestMapping(value = "getInitCommodity", method = RequestMethod.GET)
    @ResponseBody
    public String getInitCommodity(HttpServletRequest request, HttpServletResponse response) {
        tipboxInitCommodity tipboxInitCommodity = new tipboxInitCommodity();
        //获取所有单位
        List<SysCompany> SysCompany = SysCompanyService.getAllCompany();
        //获取所有客户
        List<SysCustomer> SysCustomer = SysCustomerService.getAllCustomer();
        tipboxInitCommodity.setSysCompany(SysCompany);
        tipboxInitCommodity.setSysCustomer(SysCustomer);
        tipboxInitCommodity.setStatus("200");
        tipboxInitCommodity.setMessage("返回成功!");
        return JSON.toJSONString(tipboxInitCommodity);
    }
}
