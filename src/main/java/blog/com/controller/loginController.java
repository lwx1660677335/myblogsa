package blog.com.controller;

import blog.com.Exception.AccountException;
import blog.com.blogUtils.revertMessage;
import blog.com.serverce.SysUserService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.subject.support.DefaultWebSubjectContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping(value = "/login")
@RestController
public class loginController {
    private static final Logger LOGGER = Logger.getLogger(loginController.class);
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SessionDAO sessionDAO;


    @RequestMapping(value = "/{num}", method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        /*ModelAndView modelAndView=new ModelAndView("/500");*/
        revertMessage revertMessage = new revertMessage();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        Cookie[] cookies =request.getCookies();
        if (cookies!=null){
        for (Cookie cookiesa:cookies
             ) {
            System.out.println("cookie:"+cookiesa);
        }}
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            if (currentUser.isAuthenticated()) {
                Collection<Session> sessions = sessionDAO.getActiveSessions();
                System.out.println("用户[" + token.getUsername() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
                revertMessage.setStatus("200");
                revertMessage.setMessage("登陆成功!");
                System.out.println("获取seeion值" + request.getSession().getId() + "获取地址" + request.getContextPath());
                return JSON.toJSONString(revertMessage);
            } else {
                token.clear();
                return JSON.toJSONString(revertMessage);
            }
        } catch (UnknownAccountException uae) {
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,未知账户");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("验证未通过,未知账户");
            return JSON.toJSONString(revertMessage);
        } catch (IncorrectCredentialsException ice) {
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,错误的凭证");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("验证未通过,错误的密码");
            return JSON.toJSONString(revertMessage);
        } catch (LockedAccountException lae) {
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("账户已锁定");
            return JSON.toJSONString(revertMessage);
        } catch (ExcessiveAttemptsException eae) {
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,错误次数过多");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("验证未通过,错误次数过多");
            return JSON.toJSONString(revertMessage);
        }catch (DisabledAccountException eae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
            revertMessage.setSessions("500");
            revertMessage.setStatus("500");
            revertMessage.setMessage("验证未通过,账户已锁定");
            return JSON.toJSONString(revertMessage);
        }catch (AccountException eae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..数据库出现相同名字重复数据!");
            revertMessage.setSessions("500");
            revertMessage.setStatus("500");
            revertMessage.setMessage("数据库出现相同名字重复数据!");
            return JSON.toJSONString(revertMessage);
        }  catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..详情错误"+ae.getMessage());
            revertMessage.setSessions("401");
            revertMessage.setStatus("401");
            revertMessage.setMessage("详情错误:"+ae.getMessage());
        }catch (Exception ae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..详情错误"+ae.getMessage());
            revertMessage.setSessions("500");
            revertMessage.setStatus("500");
            revertMessage.setMessage("详情错误:"+ae.getMessage());
        }
        return JSON.toJSONString(revertMessage);

    }

    /* @RequestMapping(value = "getCurrentUser",method = RequestMethod.GET)
     public String getCurrentUser(){


     }*/
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.logout();
        } catch (Exception e) {
            LOGGER.error("errorMessage:" + e.getMessage());
        }
        return "redirect:login";
    }
    @RequestMapping(value = "menulist", method = RequestMethod.GET)
    public String menulist() {
        Subject subject = SecurityUtils.getSubject();
        try {
            String s=(String)subject.getSession().getAttribute(DefaultWebSubjectContext.PRINCIPALS_SESSION_KEY);
        } catch (Exception e) {
            LOGGER.error("errorMessage:" + e.getMessage());
        }
        return "redirect:login";
    }
}
