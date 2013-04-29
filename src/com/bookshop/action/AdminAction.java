package com.bookshop.action;

import java.util.Map;
import javax.annotation.Resource;
import com.bookshop.entity.Admin;
import com.bookshop.service.AdminService;
import com.bookshop.util.BookStoreConstant;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@SuppressWarnings("serial")
public class AdminAction extends ActionSupport{
	@Resource
	private AdminService adminService;
	private Map<String,Object> session;
	private Admin admin;
	
	public String login(){
		int isLogin=adminService.login(admin.getAccount(), admin.getPw());
		if(isLogin!=-1){
			session=ActionContext.getContext().getSession();
			session.put(BookStoreConstant.SESSION_ADMIN,isLogin);
			session.put("admin_account", admin.getAccount());
			return SUCCESS;
		}
		return LOGIN;
	}
	
	public String logout(){
		session=ActionContext.getContext().getSession();
		if(session.get("admin_account")!=null){
			session.remove("admin_account");
		}
		if(session.get(BookStoreConstant.SESSION_ADMIN)!=null){
			session.remove(BookStoreConstant.SESSION_ADMIN);
		}
		return SUCCESS;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Admin getAdmin() {
		return admin;
	}
}
