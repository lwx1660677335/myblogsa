package blog.com.blogUtils;

import java.util.List;

public class layerData {
    private int status;
    private String message;
    private int count;
    private List data;
    public layerData(){
        setMessage("当前占无数据!");
        setStatus(1);
        setCount(0);
        setData(null);
    }
    public layerData(int code,int count,List data){
        this.setMessage("返回成功!");
        this.setData(data);
        this.setStatus(code);
        this.setCount(count);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
