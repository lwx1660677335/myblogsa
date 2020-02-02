package blog.com.entity;

/**
 * 商品表
 */
public class SysCommodity {

  private String commodityId;
  private String libraryId;
  private String commodityName;
  private String commodityCode;
  private String commodityType;
  private String commodityModel;
  private String commoditySpecs;
  private String commodityName1;
  private String supplierId;
  private String commodityStock;
  private String commodityStockState;
  private String commodityCompany;
  private double purchasePrice;
  private double stockPrice;
  private String commodityRemind;
  private java.sql.Timestamp commodityCreteTime;
  private String backlog;
  private String remark;
  private SysCustomer SysCustomer;
  private SysCompany SysCompany;

  public blog.com.entity.SysCustomer getSysCustomer() {
    return SysCustomer;
  }

  public void setSysCustomer(blog.com.entity.SysCustomer sysCustomer) {
    SysCustomer = sysCustomer;
  }

  public blog.com.entity.SysCompany getSysCompany() {
    return SysCompany;
  }

  public void setSysCompany(blog.com.entity.SysCompany sysCompany) {
    SysCompany = sysCompany;
  }

  public String getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(String commodityId) {
    this.commodityId = commodityId;
  }


  public String getLibraryId() {
    return libraryId;
  }

  public void setLibraryId(String libraryId) {
    this.libraryId = libraryId;
  }


  public String getCommodityName() {
    return commodityName;
  }

  public void setCommodityName(String commodityName) {
    this.commodityName = commodityName;
  }


  public String getCommodityCode() {
    return commodityCode;
  }

  public void setCommodityCode(String commodityCode) {
    this.commodityCode = commodityCode;
  }


  public String getCommodityType() {
    return commodityType;
  }

  public void setCommodityType(String commodityType) {
    this.commodityType = commodityType;
  }


  public String getCommodityModel() {
    return commodityModel;
  }

  public void setCommodityModel(String commodityModel) {
    this.commodityModel = commodityModel;
  }


  public String getCommoditySpecs() {
    return commoditySpecs;
  }

  public void setCommoditySpecs(String commoditySpecs) {
    this.commoditySpecs = commoditySpecs;
  }


  public String getCommodityName1() {
    return commodityName1;
  }

  public void setCommodityName1(String commodityName1) {
    this.commodityName1 = commodityName1;
  }


  public String getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(String supplierId) {
    this.supplierId = supplierId;
  }


  public String getCommodityStock() {
    return commodityStock;
  }

  public void setCommodityStock(String commodityStock) {
    this.commodityStock = commodityStock;
  }


  public String getCommodityStockState() {
    return commodityStockState;
  }

  public void setCommodityStockState(String commodityStockState) {
    this.commodityStockState = commodityStockState;
  }


  public String getCommodityCompany() {
    return commodityCompany;
  }

  public void setCommodityCompany(String commodityCompany) {
    this.commodityCompany = commodityCompany;
  }


  public double getPurchasePrice() {
    return purchasePrice;
  }

  public void setPurchasePrice(double purchasePrice) {
    this.purchasePrice = purchasePrice;
  }


  public double getStockPrice() {
    return stockPrice;
  }

  public void setStockPrice(double stockPrice) {
    this.stockPrice = stockPrice;
  }


  public String getCommodityRemind() {
    return commodityRemind;
  }

  public void setCommodityRemind(String commodityRemind) {
    this.commodityRemind = commodityRemind;
  }


  public java.sql.Timestamp getCommodityCreteTime() {
    return commodityCreteTime;
  }

  public void setCommodityCreteTime(java.sql.Timestamp commodityCreteTime) {
    this.commodityCreteTime = commodityCreteTime;
  }


  public String getBacklog() {
    return backlog;
  }

  public void setBacklog(String backlog) {
    this.backlog = backlog;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

}
