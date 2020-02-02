package blog.com.entity;

/**
 * 库区表
 */
public class SysReservoirarea {

  private String id;
  private String factoryLibraryId;
  private String libraryName;
  private java.sql.Date libraryCreteDate;
  private String libraryCretePeople;
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


  public String getLibraryName() {
    return libraryName;
  }

  public void setLibraryName(String libraryName) {
    this.libraryName = libraryName;
  }


  public java.sql.Date getLibraryCreteDate() {
    return libraryCreteDate;
  }

  public void setLibraryCreteDate(java.sql.Date libraryCreteDate) {
    this.libraryCreteDate = libraryCreteDate;
  }


  public String getLibraryCretePeople() {
    return libraryCretePeople;
  }

  public void setLibraryCretePeople(String libraryCretePeople) {
    this.libraryCretePeople = libraryCretePeople;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

}
