package blog.com.entity;


public class SysUser {

  private long id;
  private String sysUserKey;
  private String sysName;
  private String sysPassword;
  private java.sql.Timestamp sysCreteTime;
  private java.sql.Timestamp sysEndTime;
  private long sysCorrespondingPower;
  private String sysPowerStart;
  private String sysAdminStart;
  private String sysAdminPower;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSysUserKey() {
    return sysUserKey;
  }

  public void setSysUserKey(String sysUserKey) {
    this.sysUserKey = sysUserKey;
  }


  public String getSysName() {
    return sysName;
  }

  public void setSysName(String sysName) {
    this.sysName = sysName;
  }


  public String getSysPassword() {
    return sysPassword;
  }

  public void setSysPassword(String sysPassword) {
    this.sysPassword = sysPassword;
  }


  public java.sql.Timestamp getSysCreteTime() {
    return sysCreteTime;
  }

  public void setSysCreteTime(java.sql.Timestamp sysCreteTime) {
    this.sysCreteTime = sysCreteTime;
  }


  public java.sql.Timestamp getSysEndTime() {
    return sysEndTime;
  }

  public void setSysEndTime(java.sql.Timestamp sysEndTime) {
    this.sysEndTime = sysEndTime;
  }


  public long getSysCorrespondingPower() {
    return sysCorrespondingPower;
  }

  public void setSysCorrespondingPower(long sysCorrespondingPower) {
    this.sysCorrespondingPower = sysCorrespondingPower;
  }


  public String getSysPowerStart() {
    return sysPowerStart;
  }

  public void setSysPowerStart(String sysPowerStart) {
    this.sysPowerStart = sysPowerStart;
  }


  public String getSysAdminStart() {
    return sysAdminStart;
  }

  public void setSysAdminStart(String sysAdminStart) {
    this.sysAdminStart = sysAdminStart;
  }


  public String getSysAdminPower() {
    return sysAdminPower;
  }

  public void setSysAdminPower(String sysAdminPower) {
    this.sysAdminPower = sysAdminPower;
  }

}
