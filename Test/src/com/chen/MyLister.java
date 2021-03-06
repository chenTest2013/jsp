package com.chen;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyLister
 *
 */
@WebListener
public class MyLister implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyLister() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	System.out.println("-----contextInitialized-----");
    	ServletContext ctx=arg0.getServletContext();
    	//先注册，先执行
    	FilterRegistration en=ctx.addFilter("encoding", com.chen.Encoding.class);
    	en.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD), 
    			true, "/*");
    	en.setInitParameter("Site", "监听器开始");
    	FilterRegistration my=ctx.addFilter("myfilter", com.chen.MyFilter.class);
    	my.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,DispatcherType.FORWARD), 
    			true, "/*");
    }
	
}
