package com.oaclient.controller.register;

import com.oaclient.entity.login.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;


@Controller
@RequestMapping("login")
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/test")
    @ResponseBody
    public String  getTest(){
        long start=System.currentTimeMillis();
        logger.info("测试输出,COST:"+(System.currentTimeMillis()-start)+"MS");
        logger.info("测试输出,COST:"+(System.currentTimeMillis()-start)+"MS");
        return "ok";
    }

    /**
     * 登陆页面
     * @return
     */
    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
    public ModelAndView toLogin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/login/login");
        return mav;
    }

    /**
     * 用户登陆验证
     * @param user 用户
     * @return 登录是否成功的信息
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user,Model model) {
        ModelAndView mv=new ModelAndView();
        try{
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            // 从SecurityUtils里边创建一个 subject
            Subject subject = SecurityUtils.getSubject();
            // 在认证提交前准备 token（令牌）
            UsernamePasswordToken token = new UsernamePasswordToken(user.getPhone(),base64en.encode(md5.digest(user.getPassword().getBytes("utf-8"))));
            // 执行认证登陆
            subject.login(token);
            mv.setViewName("/index/index");
            model.addAttribute("ERROR","登录成功");
        }catch (Exception e){
            mv.setViewName("/login/login");
            model.addAttribute("ERROR","登录失败，手机号码或者密码错误");
        }
        return mv;
    }

}
