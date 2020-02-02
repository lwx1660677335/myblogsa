package blog.com.entity.voentity;

import java.util.List;

public class treeMenuData {
    private String title;//标题
    private String id;
    private String field;//节点字段名
    private List<treeMenuData> children;// 子节点。支持设定选项同父节点
    private String href;//点击节点弹出新窗口对应的 url。需开启 isJump 参数
    private boolean spread;//节点是否初始展开，默认 false
    private boolean checked;//节点是否初始为选中状态（如果开启复选框的话），默认 false
    private  boolean disabled;//节点是否为禁用状态。默认 false

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public List<treeMenuData> getChildren() {
        return children;
    }

    public void setChildren(List<treeMenuData> children) {
        this.children = children;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
