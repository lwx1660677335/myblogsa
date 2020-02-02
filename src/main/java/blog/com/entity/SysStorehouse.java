package blog.com.entity;

/**
 * 库位表
 */
public class SysStorehouse {

  private String id;
  private String factoryLibraryId;
  private String storeHouseName;
  private java.sql.Timestamp storeHouseCreteDate;
  private String storeHouseCretePeople;
  private String storeHouseType;
  private String remarks;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getFactoryLibraryId() {
    return factoryLibraryId;
  }

  public void setFactoryLibraryId(String factoryLibraryId) {
    this.factoryLibraryId = factoryLibraryId;
  }


  public String getStoreHouseName() {
    return storeHouseName;
  }

  public void setStoreHouseName(String storeHouseName) {
    this.storeHouseName = storeHouseName;
  }


  public java.sql.Timestamp getStoreHouseCreteDate() {
    return storeHouseCreteDate;
  }

  public void setStoreHouseCreteDate(java.sql.Timestamp storeHouseCreteDate) {
    this.storeHouseCreteDate = storeHouseCreteDate;
  }


  public String getStoreHouseCretePeople() {
    return storeHouseCretePeople;
  }

  public void setStoreHouseCretePeople(String storeHouseCretePeople) {
    this.storeHouseCretePeople = storeHouseCretePeople;
  }


  public String getStoreHouseType() {
    return storeHouseType;
  }

  public void setStoreHouseType(String storeHouseType) {
    this.storeHouseType = storeHouseType;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
