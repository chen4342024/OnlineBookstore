package com.bookshop.action;

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

	private File fileupload; // ��JSP��input���nameͬ��
	private String imageUrl;
	private String attachmentUrl;
	private String fileRealName;
	private HttpServletResponse response;
	// Struts2��������õ��ļ���,�������File������+FileName
	// ��˴�Ϊ 'fileupload' + 'FileName' = 'fileuploadFileName'
	private String fileuploadFileName; // �ϴ������ļ�������
	private String guid;
	private String imageFile;

	public String uploadFile() {
		String extName = ""; // �����ļ���չ��
		String newFileName = ""; // �����µ��ļ���
		PrintWriter out = null;
		String savePath = ServletActionContext.getServletContext().getRealPath(
				""); // ��ȡ��Ŀ��·��
		savePath = savePath + "/../BookImages/"+imageFile+"/";
		System.out.println(savePath);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("gbk"); // ��أ���ֹ�����ļ���������

		// ��ȡ��չ��
		if (fileuploadFileName.lastIndexOf(".") >= 0) {
			extName = fileuploadFileName.substring(fileuploadFileName
					.lastIndexOf("."));
		}
		try {
			out = response.getWriter();
			newFileName = guid+ extName; // �ļ�������������
			String filePath = savePath + newFileName;
			filePath = filePath.replace("\\", "/");
			System.out.println(newFileName);
			//����ϴ����Ƿ���ͼƬ
			if (UtilCommon.checkIsImage(extName)) {
				FileUtils.copyFile(fileupload, new File(filePath));
				out.print(newFileName);

			} else {
				out.print("<font color='red'>�ϴ����ļ����ʹ�����ѡ��jpg,jpeg,png��gif��ʽ��ͼƬ!</font>");
			}
		
			// ֱ��������Ӧ������
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			out.print("�ϴ�ʧ�ܣ�������!");
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
