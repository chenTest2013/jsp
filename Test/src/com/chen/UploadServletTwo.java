package com.chen;
import org.apache.catalina.core.ApplicationPart;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
 
@WebServlet("/UploadServlet2")
@MultipartConfig(location = "D://")
public class UploadServletTwo extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String path=this.getServletContext().getRealPath("/");
        System.out.println("path:"+path);
        //Part p=request.getPart("file1");
        Collection<Part> ps=request.getParts();
        Iterator<Part> ipar=ps.iterator();
        String msg="";
        while(ipar.hasNext()){
        	Part pf=ipar.next();
        	ApplicationPart ap= (ApplicationPart) pf;
        	
            String fname1=ap.getSubmittedFileName();
            int path_idx=fname1.lastIndexOf("\\")+1;
            String fname2=fname1.substring(path_idx,fname1.length());
            String savepath=path+"/upload/";
            File f=new File(savepath);
            
            if(!f.exists()){
            	f.mkdirs();
            }
            pf.write(savepath+fname2);
            msg=msg+fname2+"文件上传成功";

            System.out.println("Filename:"+ap.getSubmittedFileName());
            System.out.println("ContentType:"+ap.getContentType());
            System.out.println("name:"+ap.getName());
            System.out.println("size:"+ap.getSize()+"B");
           
        }
        
        out.write(msg);
//        for(ps.forEach(action);){
//        	
//        }
//        if(p.getContentType().contains("image")){
//            ApplicationPart ap= (ApplicationPart) p;
//            String fname1=ap.getSubmittedFileName();
//            int path_idx=fname1.lastIndexOf("\\")+1;
//            String fname2=fname1.substring(path_idx,fname1.length());
//            p.write(path+"/upload/"+fname2);
//            out.write("文件上传成功");
//        }else{
//            //out.write("请选择图片文件");
//            ApplicationPart ap= (ApplicationPart) p;
//            String fname1=ap.getSubmittedFileName();
//            int path_idx=fname1.lastIndexOf("\\")+1;
//            String fname2=fname1.substring(path_idx,fname1.length());
//            p.write(path+"/upload/"+fname2);
//            out.write("文件上传成功");
//        }
             
    }
}