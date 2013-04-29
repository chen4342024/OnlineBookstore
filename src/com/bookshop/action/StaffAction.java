package com.bookshop.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bookshop.entity.Staff;
import com.bookshop.service.StaffService;
import com.bookshop.util.BookStoreConstant;
import com.bookshop.util.PageUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Ա��Action��
 * 
 * @author Winds
 * 
 */
@SuppressWarnings("serial")
public class StaffAction extends BaseAction {
  @Resource
  private StaffService staffService;
  private Staff staff;
  private Long hasStaff;
  private int page;
  private int hasPages;
  private int perFolioAmount;
  private List<Integer> page_l;
  private List<Staff> staff_l;
  private Map<String, Object> session;

  private String oldPassword;
  private String newPassword;

  private String staff_id;
  private String staff_name;
  private String staff_status;
  private boolean isLike;

  public void findStaff() {
    try {
      String flag = INPUT;
      String id = new String(staff.getStaff_id().getBytes("iso-8859-1"), "utf-8");
      if (staffService.find(id) != null) {
        flag = SUCCESS;
      }
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(flag);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String addStaff() {
    try {
      String flag = INPUT;
      staff.setPw("888888");
      staff.setJoin_date(new Date());
      staff.setStatus(1);
      staff.setRemove_date(null);
      System.out.println(staff.getName());
      if (staffService.save(staff)) {
        flag = SUCCESS;
      }
      return flag;
    } catch (Exception e) {
      e.printStackTrace();
      return INPUT;
    }
  }

  public String showStaff_by_page() {
    try {
      perFolioAmount = 2; 
      String[] parms = null;
      String[] values = null;
      this.hasStaff = staffService.hasNumbers("Staff", parms, values, isLike); // ��ȡ�������
      hasPages = PageUtil.findAllPages(perFolioAmount, hasStaff);
      ; // ��ȡҳ��
      this.page_l = PageUtil.getPageList(hasPages); // ��ȡһ����1��hasPages������
      if (page <= 0) {
        page = 1;
      }
      if (hasPages == 0) {
        page = 0;
      } else {
        if (page <= 0) {
          page = 1;
        } else if (page > hasPages) {
          page = hasPages;
        }
      }

      this.staff_l = (List<Staff>) staffService.show_by_page(page, perFolioAmount, "Staff", parms, values, isLike);

      return SUCCESS;
    } catch (Exception e) {
      e.printStackTrace();
      return INPUT;
    }
  }

  public void changeStaffState() {
    try {
      String flag = INPUT;
      String id = new String(staff.getStaff_id().getBytes("iso-8859-1"), "utf-8");
      int state = staffService.updateState(id);
      if (state == 1) {
        flag = "success1";
      } else if (state == 0) {
        flag = "success2";
      }
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(flag);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String gainStaff() {
    try {
      String flag = INPUT;
      this.staff = getCurrentStaff();
      if (staff != null) {
        flag = SUCCESS;
      }
      return flag;
    } catch (Exception e) {
      e.printStackTrace();
      return INPUT;
    }
  }

  public String ModifyStaff() {

    try {
      String flag = INPUT;
      if (staffService.update(staff)) {
        flag = SUCCESS;
      }
      return flag;
    } catch (Exception e) {
      e.printStackTrace();
      return INPUT;
    }
  }

  public String login() {
    this.staff = staffService.login(staff.getStaff_id(), staff.getPw());
      getCurrentSession().put(BookStoreConstant.SESSION_STAFF, staff);
      return SUCCESS;
  }

  public void changeStaffPassword() {
    String flag = INPUT;
    try {
      flag = staffService.changePassword(staff.getStaff_id(), oldPassword, newPassword);
      HttpServletResponse response = ServletActionContext.getResponse();
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      out.print(flag);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {

    this.staff = staff;
  }

  public Long getHasStaff() {
    return hasStaff;
  }

  public void setHasStaff(Long hasStaff) {
    this.hasStaff = hasStaff;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getHasPages() {
    return hasPages;
  }

  public void setHasPages(int hasPages) {
    this.hasPages = hasPages;
  }

  public int getPerFolioAmount() {
    return perFolioAmount;
  }

  public void setPerFolioAmount(int perFolioAmount) {
    this.perFolioAmount = perFolioAmount;
  }

  public List<Integer> getPage_l() {
    return page_l;
  }

  public void setPage_l(List<Integer> page_l) {
    this.page_l = page_l;
  }

  public List<Staff> getStaff_l() {
    return staff_l;
  }

  public void setStaff_l(List<Staff> staff_l) {
    this.staff_l = staff_l;
  }

  public StaffService getStaffService() {
    return staffService;
  }

  public void setStaffService(StaffService staffService) {
    this.staffService = staffService;
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public boolean isLike() {
    return isLike;
  }

  public void setLike(boolean isLike) {
    this.isLike = isLike;
  }

  public String getStaff_id() {
    return staff_id;
  }

  public void setStaff_id(String staff_id) {
    this.staff_id = staff_id;
  }

  public String getStaff_name() {
    return staff_name;
  }

  public void setStaff_name(String staff_name) {
    this.staff_name = staff_name;
  }

  public String getStaff_status() {
    return staff_status;
  }

  public void setStaff_status(String staff_status) {
    this.staff_status = staff_status;
  }

}
