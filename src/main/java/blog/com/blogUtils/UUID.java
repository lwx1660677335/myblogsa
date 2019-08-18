package blog.com.blogUtils;

public class UUID {
    private String UUID;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }
    public UUID(){}

    /**
     * 返回值
     * @return
     */
    public static UUID createUUID(){
        int hashCodeV= java.util.UUID.randomUUID().toString().hashCode();
        if (hashCodeV<0){
            hashCodeV=Math.abs(hashCodeV);
        }
        UUID uuid=new UUID();

        uuid.setUUID(String.format("%015d",hashCodeV));
        return uuid;
    }



}
