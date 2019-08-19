<%--
  Created by IntelliJ IDEA.
  User: mo
  Date: 2019/7/9
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${map.mess}</p>
<p>${map.date}</p>
<shiro:hasRole name="admin">
    <a>显示人员为admin</a>
</shiro:hasRole><br/>
<shiro:hasRole name="common">
   <a>显示人员为common</a>
</shiro:hasRole><br/>
<shiro:hasAnyRoles name = "admin,manager">
    用户[<shiro:principal/>]拥有角色admin 或者 user
</shiro:hasAnyRoles><br/>
<shiro:hasPermission name="del">
    <a>,有删除权限</a>
</shiro:hasPermission><br/>
<shiro:hasPermission name="admin:del">
    <a>显示人员为admin,有删除权限</a>
</shiro:hasPermission><br/>
<a href="">目录</a><br/>
<a>人员</a><br/>

</body>

<!-- 每分钟检查session的状态，当session过期的时候，跳到登录页面 -->
<script type="text/javascript">
    var sessionCheck = setInterval(function(){
        // 获取session 状态
        $.ajax({
            url:'/getCurrentUser',
            type:'post',
            dataType:'json',
            success:function(data){
                if(data.result=='-1'){
                    console.log("session已过期");
                    location.href="/500";
                }else{
                    console.log("session未过期");
                }
            },
            error:function(data){
                console.log("session已过期");
                location.href="/500";
            }
        });
    },1000*5);

    function clear(){
        clearInterval(sessionCheck);
    }
</script>
</html>
