# jsp页面编码问题  
为解决jsp编码问题所想到的     
服务器环境：apache-tomcat-7.0.75      
1. 通常我们用request.setCharacterEncoding("UTF-8")解决中文参数乱码问题;但这种方式只能解决post方式提交的表单，用get提交仍旧是乱码 。    
缺点：需要在处理表单的所有jsp页面中加上request.setCharacterEncoding("UTF-8")     
      无法解决get方式的表单     
2. 方式1中也可以判断是否是get方式，若是可以这样解决get方式表单（不知为什么是ISO-8859-1！！！），String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"),"UTF-8");但任然需要在处理表单的所有jsp页面中加上类似语句，所以产生了方式2，用过滤器， 对于post方式，在过滤器的doFilter方法中设置编码。对于get方式，自定义请求包装器包装请求，将字符编码转换的工作添加到getParameter()方法中，接下来在 web.xml中配置过滤器，就不要在处理表单的所有jsp页面中判断了，也不需要添加request.setCharacterEncoding("UTF-8")，甚至不做任何修改就可。   
缺点：需要修改web.xml文件   
3. 再次探索，2中需要配置web.xml,但若不想修改web.xml,怎么办？。用注解（servlet3.0 api支持注解）。   
缺点：当配置多个过滤器时无法配置顺序(web.xml 中的 filter-mapping 元素的顺序决定了 Web 容器应用过滤器到 Servlet 的顺序)    
4. 再来，用Lister（可以用注解配置Lister，无需修改web.xml）来动态注册Filter，不用注解注册Filter，这样完美解决编码问题，总共增加几个java文件.    
## 注意   
用Lister注册Filter是，所有的Filter都不能用注解（都需要用Lister注册Filter），否则顺序无效    