package com.bookshop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookshop.action.AdminAction;
import com.bookshop.entity.Admin;
import com.bookshop.util.BookStoreConstant;

public class LoginFilter implements Filter {
  public static final int ROLE_ADMIN = 1;
  public static final int ROLE_STAFF = 2;
  public static final int ROLE_CUSTOMER = 3;

  public void destroy() {
    // TODO Auto-generated method stub

  }

  public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();
    String uri = request.getRequestURI();
    boolean isLogin = true;
    int login_role = 0;
    if (uri.contains("/admin/")) {
      if (session.getAttribute(BookStoreConstant.SESSION_ADMIN) == null) {
        login_role = ROLE_ADMIN;
        isLogin = false;
      }
    } else if (uri.contains("/customer/")) {
      if (session.getAttribute(BookStoreConstant.SESSION_CUSTOMER) == null) {
        login_role = ROLE_CUSTOMER;
        isLogin = false;
      }
    } else if (uri.contains("/staff/")) {
      if (session.getAttribute(BookStoreConstant.SESSION_STAFF) == null) {
        login_role = ROLE_STAFF;
        isLogin = false;
      }
    }
    if (!isLogin && login_role == ROLE_ADMIN) {
      response.sendRedirect(request.getContextPath() + "/adminLogin.jsp");
      return;
    } else if (!isLogin && login_role == ROLE_CUSTOMER) {
      response.sendRedirect(request.getContextPath() + "/customerLogin.jsp");
      return;
    } else if (!isLogin && login_role == ROLE_STAFF) {
      response.sendRedirect(request.getContextPath() + "/staffLogin.jsp");
      return;
    }
    try {
      filterChain.doFilter(request, response);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub

  }

}
