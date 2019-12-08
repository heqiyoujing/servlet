package com.servlet.study;

import javax.servlet.*;

/**
 * @author: yiqq
 * @date: 2018/8/21
 * @description:
 */
public class LogFilter implements Filter {
    public void  init(FilterConfig config) throws ServletException {
        //获得过滤器名字
        String filterName = config.getFilterName();
        // 获取初始化参数
        String site = config.getInitParameter("Site");

        // 输出初始化参数
        System.out.println("网站名称: " + site);
    }
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        // 输出站点名称
        System.out.println("站点网址：http://www.runoob.com");

        // 把请求传回过滤链
        chain.doFilter(request,response);
    }
    public void destroy( ){
        /* 在 Filter 实例被 Web 容器从服务移除之前调用 */
    }
}
