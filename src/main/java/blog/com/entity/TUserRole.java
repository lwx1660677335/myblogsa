package blog.com.entity;


public class TUserRole {

  private long id;
  private String idKey;
  private String userId;
  private String roleId;


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


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId;
  }

}
