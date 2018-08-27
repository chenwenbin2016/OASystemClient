<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>OA系统登录</title>
    <script type="text/javascript">
        var ctx="${ctx}";
    </script>
    <link href="${ctx}/static/css/default.css" rel="stylesheet" type="text/css" />
    <!--必要样式-->
    <link href="${ctx}/static/css/styles.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/demo.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/static/css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class='login'>
    <input type="hidden" value="${ERROR}" id="ERROR" />
    <div class='login_title'>
        <span>OA系统登录</span>
    </div>
    <form class="layui-form" action="${ctx}/login/login" method="post">
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img alt="" src='${ctx}/static/image/user_icon_copy.png'>
            </div>
            <input  placeholder='请输入手机号码' name="phone"  type='text' autocomplete="off" />
            <div class='validation'>
                <img alt="" src='${ctx}/static/image/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='${ctx}/static/image/lock_icon_copy.png'>
            </div>
            <input  placeholder='请输入密码' name="password" type='password' autocomplete="off">
            <div class='validation'>
                <img alt="" src='image/tick.png'>
            </div>
        </div>
        <div class='login_fields__submit'>
            <input type='submit' lay-submit lay-filter="login" value='登录'>
        </div>
    </div>
    </form>

</div>
<script src="${ctx}/static/js/layui/layui.js"></script>
<script type="text/javascript">
    var layer,form,$;
    layui.use(['layer', 'form','jquery'], function () {
         layer = layui.layer;
         form = layui.form;
         $= layui.jquery;
         $(function(){
            var error=$("#ERROR").val();
            if(error){
                var error=$("#ERROR").val();
                layer.msg(error);
                $("#ERROR").val("");
            }
         });
        
        //监听提交
        form.on('submit(login)', function(data){
            //layer.msg(JSON.stringify(data.field));
            if (!data.field.phone){
                layer.msg("手机号码不能为空");
                return false;
            }
            if(!data.field.password){
                layer.msg("密码不能为空");
                return false;
            }
            return true;
        });
    });
</script>

</body>
</html>