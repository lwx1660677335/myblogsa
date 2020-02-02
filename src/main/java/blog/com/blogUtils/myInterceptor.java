package blog.com.blogUtils;

import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class myInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest HttpServletRequest, HttpServletResponse HttpServletResponse,Object handler){
        HttpSession HttpSession=HttpServletRequest.getSession();
        revertMessage revertMessage=new revertMessage();
        String username=(String)HttpSession.getAttribute("username");
//        if (username.isEmpty()){
//
//        }
        System.out.println("拦截器!");
        return true;
    }
}
