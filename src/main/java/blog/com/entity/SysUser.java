package blog.com.entity;
import java.sql.Timestamp;


public class SysUser {

  private long id;
  private String sysUserKey;
  private String sysName;
  private String sysPassword;
  private String sysgender;
  private Timestamp sysCreteTime;
  private Timestamp sysEndTime;
  private long sysCorrespondingPower;
  private String sysPowerStart;
  private String sysAdminStart;
  private String sysAdminPower;
  private String sysDiscontinuedState;
  private String sysLockedState;
  private String sysdepartment;
  private SysDepartment sysdepartmentName;
  private String systelepthone;
  private String sysadress;
  private String sysspanned;
  private String sysaccess;

  public SysDepartment getSysdepartmentName() {
    return sysdepartmentName;
  }

  public void setSysdepartmentName(SysDepartment sysdepartmentName) {
    this.sysdepartmentName = sysdepartmentName;
  }

  public String getSysdepartment() {
    return sysdepartment;
  }

  public void setSysdepartment(String sysdepartment) {
    this.sysdepartment = sysdepartment;
  }

  public String getSystelepthone() {
    return systelepthone;
  }

  public void setSystelepthone(String systelepthone) {
    this.systelepthone = systelepthone;
  }

  public String getSysadress() {
    return sysadress;
  }

  public void setSysadress(String sysadress) {
    this.sysadress = sysadress;
  }

  public String getSysspanned() {
    return sysspanned;
  }

  public void setSysspanned(String sysspanned) {
    this.sysspanned = sysspanned;
  }

  public String getSysaccess() {
    return sysaccess;
  }

  public void setSysaccess(String sysaccess) {
    this.sysaccess = sysaccess;
  }

  public String getSysDiscontinuedState() {
    return sysDiscontinuedState;
  }

  public void setSysDiscontinuedState(String sysDiscontinuedState) {
    this.sysDiscontinuedState = sysDiscontinuedState;
  }

  public String getSysLockedState() {
    return sysLockedState;
  }

  public void setSysLockedState(String sysLockedState) {
    this.sysLockedState = sysLockedState;
  }

  public String getSysgender() {
    return sysgender;
  }

  public void setSysgender(String sysgender) {
    this.sysgender = sysgender;
  }

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
