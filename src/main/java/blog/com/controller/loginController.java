package blog.com.controller;

import blog.com.blogUtils.revertMessage;
import blog.com.serverce.SysUserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RequestMapping(value = "/test")
@Controller
public class loginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SessionDAO sessionDAO;
    @RequestMapping(value = "/login/{num}",method = RequestMethod.GET)
    @ResponseBody
/*
    @RequiresRoles("admin")
*/
    public String login(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
       /* ModelAndView modelAndView=new ModelAndView("/500");*/
        revertMessage revertMessage=new revertMessage();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
            /*resultPageURL = "main";*/
        }catch(UnknownAccountException uae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,未知账户");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("未知账户");
        }catch(IncorrectCredentialsException ice){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,错误的凭证");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("密码不正确");
            request.setAttribute("message_login", "密码不正确");
        }catch(LockedAccountException lae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,账户已锁定");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,错误次数过多");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("用户名或密码错误次数过多");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + token.getUsername() + "]进行登录验证..验证未通过,堆栈轨迹如下");
            revertMessage.setSessions("1231231312");
            revertMessage.setStatus("500");
            revertMessage.setMessage("用户名或密码不正确");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            Collection<Session> sessions=sessionDAO.getActiveSessions();
            System.out.println("用户[" + token.getUsername() + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            Map<String,String> map=new HashMap<>();
            map.put("mess","登陆成功!当前系统时间");
            map.put("date", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            revertMessage.setStatus("200");
            revertMessage.setMessage("登陆成功!");

            return StringEscapeUtils.unescapeJavaScript(JSONObject.toJSONString(revertMessage));
        }else{
            token.clear();
            return StringEscapeUtils.unescapeJavaScript(JSONObject.toJSONString(revertMessage));
        }
    }
}
