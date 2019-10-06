package blog.com.blogUtils;



public class revertMessage   {
    private int id;
    private String sessions;
    private String status;
    private String message;

    public revertMessage(){
        this.id=141;
        this.sessions="000000";
        this.status="500";
        this.message="出现错误请联系管理!telephone:18328341582";
    }
    public revertMessage(int id,String sessions,String status,String message){
        this.id=141;
        this.sessions="000000";
        this.status="500";
        this.message="出现错误请联系管理!telephone:18328341582";
    }
    public revertMessage(boolean status){
        this.id=141;
        this.sessions="***";
        this.status="200";
        this.message="如有问题请联系!telephone:18328341582";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
