package blog.com.entity;

/**
 * 页面显示信息设置
 */
public class Pageparameters {

  private String id;
  private String projectName;
  private String pageNumber;
  private String pageSizeNumber;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }


  public String getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(String pageNumber) {
    this.pageNumber = pageNumber;
  }


  public String getPageSizeNumber() {
    return pageSizeNumber;
  }

  public void setPageSizeNumber(String pageSizeNumber) {
    this.pageSizeNumber = pageSizeNumber;
  }

}
