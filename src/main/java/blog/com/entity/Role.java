package blog.com.entity;


public class Role {

  private long id;
  private String roleKey;
  private String rolename;
  private String roleCode;
  private java.sql.Timestamp roleCreteTime;
  private java.sql.Timestamp roleUpteTime;
  private String roleUpteEndName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRoleKey() {
    return roleKey;
  }

  public void setRoleKey(String roleKey) {
    this.roleKey = roleKey;
  }


  public String getRolename() {
    return rolename;
  }

  public void setRolename(String rolename) {
    this.rolename = rolename;
  }


  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode;
  }


  public java.sql.Timestamp getRoleCreteTime() {
    return roleCreteTime;
  }

  public void setRoleCreteTime(java.sql.Timestamp roleCreteTime) {
    this.roleCreteTime = roleCreteTime;
  }


  public java.sql.Timestamp getRoleUpteTime() {
    return roleUpteTime;
  }

  public void setRoleUpteTime(java.sql.Timestamp roleUpteTime) {
    this.roleUpteTime = roleUpteTime;
  }


  public String getRoleUpteEndName() {
    return roleUpteEndName;
  }

  public void setRoleUpteEndName(String roleUpteEndName) {
    this.roleUpteEndName = roleUpteEndName;
  }

}
