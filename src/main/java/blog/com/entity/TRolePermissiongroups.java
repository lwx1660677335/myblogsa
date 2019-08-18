package blog.com.entity;


public class TRolePermissiongroups {

  private long id;
  private String idKey;
  private String roleIdKey;
  private String permissiongroupsKey;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getIdKey() {
    return idKey;
  }

  public void setIdKey(String idKey) {
    this.idKey = idKey;
  }


  public String getRoleIdKey() {
    return roleIdKey;
  }

  public void setRoleIdKey(String roleIdKey) {
    this.roleIdKey = roleIdKey;
  }


  public String getPermissiongroupsKey() {
    return permissiongroupsKey;
  }

  public void setPermissiongroupsKey(String permissiongroupsKey) {
    this.permissiongroupsKey = permissiongroupsKey;
  }

}
