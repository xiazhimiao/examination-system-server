package com.xiazhimiao.controller;

import com.xiazhimiao.pojo.User;
import com.xiazhimiao.pojo.Result;
import com.xiazhimiao.service.UserService;
import com.xiazhimiao.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    //注入service
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("登录操作：{}", user);
        User e = userService.login(user);

        //登录成功，生成令牌，下发令牌
        if (e != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());

            String jwt = JwtUtils.generateJwt(claims);
            //return Result.success(jwt);
            return new Result(0, "登录成功！", jwt);
        }


        //登录失败
        return e != null ? Result.success() : Result.error("用户名或密码错误");
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        log.info("注册操作：{}", user);
        User u = userService.getUsername(user);
        if (u != null) {
            return new Result(1, "注册失败", null);
        }
        userService.register(user);
        return new Result(0, "注册成功", null);
    }

    @GetMapping("/userInfo")
    public Result userInfoService(HttpServletRequest rsq) {

        //3.获取请求头中的令牌（token）Authorization中
        String jwt = rsq.getHeader("Authorization");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer id = claims.get("id", Integer.class);
        log.info("查询用户id：{}的信息", id);
        User user = userService.userInfoService(id);
        return Result.success(user);
    }


}
