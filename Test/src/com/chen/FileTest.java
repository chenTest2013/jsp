package com.chen;

import java.io.File;

public class FileTest {

	public FileTest() {
		// TODO Auto-generated constructor stub
	}
public static void main(String[] args){
	File f=new File("E:\\study1\\");
	/*if(!f.exists()){
		System.out.println("mkdir:"+f.mkdir());
	}else{
		System.out.println("mkdirs:"+f.mkdirs());
	}*/
	System.out.println("mkdirs:"+f.mkdirs());
}
}
