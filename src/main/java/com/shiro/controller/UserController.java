package com.shiro.controller;

import com.shiro.dto.Result;
import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Create by 六
 * Date:18-7-20
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping(value = {"/",""},method = RequestMethod.GET)
    public String shiro(){
        return "login";
    }


    @RequestMapping(value = "/fail",method = RequestMethod.GET)
    public String fail(){
        logger.info("登录失败");
        return "fail";
    }

    @RequestMapping(value = "/success")
    public String success(){
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result login(@RequestParam("account") String account,
                        @RequestParam("pwd") String pwd){
        if(null==account || null==pwd || account.isEmpty() || pwd.isEmpty()){
            return new Result(false,"用户名或者密码为空");
        }else {
            User user1 = (User) redisTemplate.opsForValue().get("user");
            //从缓存中查询
            if(null==user1){
                User user = userService.select(account);
                if(null==user){
                    return new Result(false,"对不起，数据库中没有这个人");
                }else {
                    if(!pwd.equals(user.getPswd())){
                        return new Result(false,"密码错误");
                    }
                    return new Result(true,user,"查有此人");
                }
            }else {
                return new Result(true,user1,"查有此人");
            }

        }
    }
}
