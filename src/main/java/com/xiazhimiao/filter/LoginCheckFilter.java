package com.xiazhimiao.filter;

import com.alibaba.fastjson.JSONObject;
import com.xiazhimiao.pojo.Result;
import com.xiazhimiao.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest rsq = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        //1.获取请求url
        String url = rsq.getRequestURI().toString();
        log.info("请求的url{}",url);

        //2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if(url.contains("login") || url.contains("register")){
            log.info("登录操作，放行---");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //3.获取请求头中的令牌（token）Authorization中
        String jwt = rsq.getHeader("Authorization");

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录的信息");
            // 打印请求信息
            log.info("Request received with token: {}", rsq.getHeader("Authorization"));
            Result error = Result.error("NOT_LOGIN");
            //手动转换对象--json-----》阿里巴巴fastjson
            String notLogin = JSONObject.toJSONString(error);

            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为 401

            resp.getWriter().write(notLogin);
            return;

        }
        //5.解析token，如果解析失败，返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("NOT_login");
            //手动转换对象--json-----》阿里巴巴fastjson
            String notLogin = JSONObject.toJSONString(error);

            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码为 401

            resp.getWriter().write(notLogin);
            return;
        }

        // 6.放行
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
