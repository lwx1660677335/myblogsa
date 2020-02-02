package blog.com.blogUtils;

public class UUID {
    private static UUID uuid=null;

    public UUID(){}
    public static UUID getUUID(){
        if (uuid==null){
            uuid=new UUID();
        }
        return uuid;
    }
    /**
     * 返回值
     * @return
     */
    public static String createUUID(){
        int hashCodeV= java.util.UUID.randomUUID().toString().hashCode();
        if (hashCodeV<0){
            hashCodeV=Math.abs(hashCodeV);
        }
        /*uuid.setUUID(String.format("%015d",hashCodeV));*/
        return String.format("%015d",hashCodeV);
    }

}
