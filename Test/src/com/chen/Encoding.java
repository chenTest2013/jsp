package com.chen;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
//@WebFilter(
//		filterName="FilterC_Encoding",
//		urlPatterns="/*",
//		initParams = {
//				@WebInitParam(name = "Site", value = "加哇家")
//					 }
//		)
public class Encoding implements Filter{
    private FilterConfig config;
    private String charset="UTF-8";
	public Encoding() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 输出站点名称
		System.out.println("站点网址：cjava.cn");
		// 把请求传回过滤链
		request.setCharacterEncoding(charset);
		response.setCharacterEncoding(charset);
		//新增加的代码          
        HttpServletRequest req = (HttpServletRequest)request;  
          
        if(req.getMethod().equalsIgnoreCase("get"))  
        {   
        	System.out.println("get方法："+charset);
            req = new GetHttpServletRequestWrapper(req,charset);  
        }else{
        	
        }
          
        System.out.println("----请求被"+config.getFilterName()+"过滤");
		chain.doFilter(req,response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(arg0.getFilterName()+":"+System.currentTimeMillis());
		this.config=arg0;
		// 获取初始化参数
		String site = arg0.getInitParameter("Site"); 
		// 输出初始化参数
		System.out.println("网站名称: " + site);
		
		
	}

}
