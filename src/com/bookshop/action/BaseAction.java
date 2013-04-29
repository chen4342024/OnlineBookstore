package com.bookshop.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bookshop.entity.Admin;
import com.bookshop.entity.Customer;
import com.bookshop.entity.Staff;
import com.bookshop.util.BookStoreConstant;
import com.opensymphony.xwork2.ActionContext;

public class BaseAction {
  public static final String SUCCESS = "success";
  public static final String NONE = "none";
  public static final String ERROR = "error";
  public static final String INPUT = "input";
  public static final String LOGIN = "login";
  public Map<String, Object> getCurrentSession() {
    Map<String, Object> session = ActionContext.getContext().getSession();
    // TODO should check session is null
    return session;
  }

  protected HttpServletResponse getResponse() {
    return (HttpServletResponse) ServletActionContext.getResponse();
  }

  protected HttpServletResponse getRequest() {
    return (HttpServletResponse) ServletActionContext.getRequest();
  }

  public Customer getCurrentCustomer() {
    return (Customer) getCurrentSession().get(BookStoreConstant.SESSION_CUSTOMER);
  }

  public Admin getCurrentAdmin() {
    return (Admin) getCurrentSession().get(BookStoreConstant.SESSION_ADMIN);
  }

  public Staff getCurrentStaff() {
    return (Staff) getCurrentSession().get(BookStoreConstant.SESSION_STAFF);
  }
}
