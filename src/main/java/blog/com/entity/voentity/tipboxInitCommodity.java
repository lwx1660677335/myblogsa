package blog.com.entity.voentity;

import blog.com.entity.Role;
import blog.com.entity.SysDepartment;
import blog.com.entity.SysUser;

import java.util.List;

public class tipboxInitCommodity {
    private String status;
    private List sysCompany;
    private List sysCustomer;
    private String message;

    public tipboxInitCommodity(){
        this.status="500";
        this.message="出现错误请联系管理!telephone:18328341582";
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List getSysCompany() {
        return sysCompany;
    }

    public void setSysCompany(List sysCompany) {
        this.sysCompany = sysCompany;
    }

    public List getSysCustomer() {
        return sysCustomer;
    }

    public void setSysCustomer(List sysCustomer) {
        this.sysCustomer = sysCustomer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
