package blog.com.blogUtils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class SeesionManagerUtils {
    @Autowired
    private SessionDAO sessionDAO;
    private int SeeionSize=-1;
    private void setSeesion(Object key,Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if(null != currentUser){
            Session session = currentUser.getSession(true);
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if(null != session){
                session.setAttribute(key, value);
            }
        }
    }


    private void DelSeeion(String obj){
        Collection<Session> sessions=sessionDAO.getActiveSessions();
        SeeionSize=sessions.size();
        for (Session session:sessions
        ) {
            if (session.getAttribute(obj)!=null){
                sessionDAO.delete(session);
            }
        }
    }
    private Session getSession(String obj){
        Collection<Session> sessions=sessionDAO.getActiveSessions();
        for (Session session:sessions
        ) {
            if (session.getAttribute(obj)!=null){
                return session;
            }
        }
        return null;
    }
}
