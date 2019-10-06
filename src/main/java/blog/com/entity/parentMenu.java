package blog.com.entity;

import java.util.List;

/**
 * 菜单栏
 * 父级菜单栏
 */
public class parentMenu {
    private long id;
    private String permissionKey;
    private String permissionName;
    private String permissionCode;
    private long permissionNumber;
    private String permissionUrl;
    private String permissionFaterNumber;
    private List<childMenu> permissionSonNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public long getPermissionNumber() {
        return permissionNumber;
    }

    public void setPermissionNumber(long permissionNumber) {
        this.permissionNumber = permissionNumber;
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getPermissionFaterNumber() {
        return permissionFaterNumber;
    }

    public void setPermissionFaterNumber(String permissionFaterNumber) {
        this.permissionFaterNumber = permissionFaterNumber;
    }

    public List<childMenu> getPermissionSonNumber() {
        return permissionSonNumber;
    }

    public void setPermissionSonNumber(List<childMenu> permissionSonNumber) {
        this.permissionSonNumber = permissionSonNumber;
    }
}
