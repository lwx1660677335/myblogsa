package blog.com.blogUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public String getTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return  simpleDateFormat.format(date);
    }
    public Timestamp getTimestamp(){
        Date date=new Date();
        return new Timestamp(date.getTime());
    }

}
