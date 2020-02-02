package blog.com.entity;


public class SysCustomer {

  private String id;
  private String customerType;
  private String customerName;
  private String customerUser;
  private String customerPhone;
  private String customerAdress;
  private String remark;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getCustomerType() {
    return customerType;
  }

  public void setCustomerType(String customerType) {
    this.customerType = customerType;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public String getCustomerUser() {
    return customerUser;
  }

  public void setCustomerUser(String customerUser) {
    this.customerUser = customerUser;
  }


  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }


  public String getCustomerAdress() {
    return customerAdress;
  }

  public void setCustomerAdress(String customerAdress) {
    this.customerAdress = customerAdress;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
