package com.bookshop.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.util.StringUtil;

public class DuplicationSubmissionFilter implements Filter {
  public static final String DUPLICATE_SUBMISSION_CONFIRM_PAGE = "/exceptionHandler/duplicate_submission.jsp";
  public static final String TOKEN_NAME = "submissionToken";
  public static final String UNCHECK_DUPLICATION_SUBMISSION = "form:uncheck_duplication_submission";
  private String[] uncheckKeys;

  public void destroy() {
  }

  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
    throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) arg0;
    HttpServletResponse response = (HttpServletResponse) arg1;
    HttpSession session = request.getSession();
    String submitToken = request.getParameter(TOKEN_NAME);
    String sessionToken = (String) session.getAttribute(TOKEN_NAME);
    if (submitToken != null && sessionToken != null && !submitToken.equals(sessionToken)) {
      response.sendRedirect(getURL(request));
      return;
    } else {
      sessionToken = registerAuditToken();
      session.setAttribute(TOKEN_NAME, sessionToken);
    }
    chain.doFilter(request, response);
  }
  private String registerAuditToken() {
    Long resisterTime = (new Date()).getTime();
    return resisterTime.toString();
  }
  private String getURL(HttpServletRequest servletRequest) {
    String originURL = servletRequest.getContextPath() + DUPLICATE_SUBMISSION_CONFIRM_PAGE;
    return originURL;
  }

  public void init(FilterConfig config) throws ServletException {
    setUncheckKeys(config.getInitParameter("uncheckKeys"));
  }

  public String[] getUncheckKeys() {
    return uncheckKeys;
  }

  public void setUncheckKeys(String uncheckKeys) {
    if (!StringUtil.isNullOrEmpty(uncheckKeys)) {
      this.uncheckKeys = uncheckKeys.split(StringUtil.COMMA);
    }
  }

}
