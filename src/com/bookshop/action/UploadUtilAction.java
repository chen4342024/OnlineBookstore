﻿package com.bookshop.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.bookshop.util.UtilCommon;
import com.opensymphony.xwork2.ActionSupport;

public class UploadUtilAction extends ActionSupport implements
		ServletResponseAware {

	private File fileupload; 
	private String imageUrl;
	private String attachmentUrl;
	private String fileRealName;
	private HttpServletResponse response;
	private String fileuploadFileName; 
	private String guid;
	private String imageFile;

	public String uploadFile() {
		String extName = ""; 
		String newFileName = ""; 
		PrintWriter out = null;
		String savePath = ServletActionContext.getServletContext().getRealPath(
				""); 
		savePath = savePath + "/../BookImages/"+imageFile+"/";
		System.out.println(savePath);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk");

		if (fileuploadFileName.lastIndexOf(".") >= 0) {
			extName = fileuploadFileName.substring(fileuploadFileName
					.lastIndexOf("."));
		}
		try {
			out = response.getWriter();
			newFileName = guid+ extName; 
			String filePath = savePath + newFileName;
			filePath = filePath.replace("\\", "/");
			System.out.println(newFileName);
	
			if (UtilCommon.checkIsImage(extName)) {
				FileUtils.copyFile(fileupload, new File(filePath));
				out.print(newFileName);
			} else {
				out.print("<font color='red'>image pattern is unsupport</font>");
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			out.print("add book image error");
		}
		return null;
	}

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public String getFileRealName() {
		return fileRealName;
	}

	public void setFileRealName(String fileRealName) {
		this.fileRealName = fileRealName;
	}
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
    
}
