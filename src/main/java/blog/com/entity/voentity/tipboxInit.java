package blog.com.entity.voentity;

import blog.com.entity.Role;
import blog.com.entity.SysDepartment;
import blog.com.entity.SysUser;
import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.List;

public class tipboxInit {
    private SysUser sysUser;
    private String status;
    private List<SysDepartment> sysDepartments;
    private List<Role> roles;
    private List<treeMenuData> treeMenuDatas;
    private String message;

    public tipboxInit(){
        this.status="500";
        this.message="出现错误请联系管理!telephone:18328341582";
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SysDepartment> getSysDepartments() {
        return sysDepartments;
    }

    public void setSysDepartments(List<SysDepartment> sysDepartments) {
        this.sysDepartments = sysDepartments;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<treeMenuData> getTreeMenuDatas() {
        return treeMenuDatas;
    }

    public void setTreeMenuDatas(List<treeMenuData> treeMenuDatas) {
        this.treeMenuDatas = treeMenuDatas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
