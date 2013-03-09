package com.bookshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bookshop.entity.Order;
import com.bookshop.entity.RejectedApply;
import com.bookshop.service.RejectedApplyService;
import com.bookshop.util.PageUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��Ա�˻�������ϢAction��
 * @author Winds
 *
 */
@SuppressWarnings("serial")
public class RejectedApplyAction extends ActionSupport {
	@Resource 
	private RejectedApplyService rejectedApplyService;
	private RejectedApply rejectedApply;
	
	private Long hasRecord;//��ݵ��ܸ���
	private int page;		 //��ǰҳ
	private int hasPages;	 //��ҳ��
	private int perFolioAmount;  //ÿҳ��ݵ�����
	private List<Integer> page_l;//��ȡһ����1��hasPages������
	private List<RejectedApply> Record_l; //��ǰҳ�����
	private int isPass; //��־��˶����Ľ��1Ϊͨ��0Ϊ��ͨ��
	private int status=0;//��־��Ҫ��ѯ����״̬�µ��˻�����
	private String staff_id ;
	private Map<String,Object> session;
	
	private String parm =null;//ɸѡ����Ĳ���
	private String value = null;//ɸѡ�����ֵ
	private String beginTime;
	private String endTime;
	private boolean clear;//���ɸѡ�Ĳ���

	@SuppressWarnings("unchecked")
	/*
	 * ��ʾ�˻�����
	 */
	public String show_rejectedApply(){
		if(clear){
			parm = null;
			value = null;
			clear=false;
		}
		String[] parms = new String[]{"status"};
		String[] values = new String[]{String.valueOf(status)};
		boolean isLike = false;
		try{
			if(perFolioAmount <=0)
				perFolioAmount =4;
			if(parm !=null && value !=null && !value.trim().equals("")){
				parms = new String []{parm,"status"};
				values = new String[]{value,String.valueOf(status)};
				isLike = true;
			}
			if(parm !=null && parm.equals("apply_date")){
				hasRecord = rejectedApplyService.hasNumbers("RejectedApply", parm, beginTime, endTime,"status",String.valueOf(status));
				hasPages = PageUtil.findAllPages(perFolioAmount, hasRecord);
				page_l = PageUtil.getPageList(hasPages);
				if (hasPages == 0) {
					hasPages = 1;
					page = 0;
				} 
				if (page <= 0) {
					page = 1;
				}else if (page > hasPages) {
					page = hasPages;
				}
				this.Record_l = (List<RejectedApply>)rejectedApplyService.show_by_page(page, perFolioAmount, "RejectedApply", parm, beginTime, endTime,"status",String.valueOf(status));
				return String.valueOf(status);
			}
			hasRecord = rejectedApplyService.hasNumbers("RejectedApply", parms, values,isLike);
			hasPages = PageUtil.findAllPages(perFolioAmount, hasRecord);
			page_l = PageUtil.getPageList(hasPages);
			if (hasPages == 0) {
				hasPages = 1;
				page = 0;
			} 
			if (page <= 0) {
				page = 1;
			}else if (page > hasPages) {
				page = hasPages;
			}
			this.Record_l = (List<RejectedApply>)rejectedApplyService.show_by_page(page, perFolioAmount, "RejectedApply", parms, values,isLike);
			
			return String.valueOf(status);
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	/*
	 * ����˻�����
	 */
	public void audit_rejectedApply(){
		String flag = "input";
		System.out.println(isPass);
		System.out.println("id--->"+rejectedApply.getRejected_apply_id());
		PrintWriter out = null;
		session = ActionContext.getContext().getSession();
		staff_id = session.get("staff_id").toString();
		try{
			rejectedApplyService.audit_rejectedApply(staff_id,rejectedApply.getRejected_apply_id(), isPass);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			flag = "audit";
			out.print(flag);
			out.flush();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(out != null)
				out.close();
		}
	}
	/*
	 * ȷ���ջ���ɽ���
	 */
	public void complete_rejectedApply(){
		String flag = "input";
		System.out.println(isPass);
		System.out.println("id--->"+rejectedApply.getRejected_apply_id());
		PrintWriter out = null;
		session = ActionContext.getContext().getSession();
		staff_id = session.get("staff_id").toString();
		rejectedApplyService.complete_rejectedApply(staff_id,rejectedApply.getRejected_apply_id());
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			flag = "complete";
			out.print(flag);
			out.flush();
			out.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(out != null)
				out.close();
		}
	}
	public String showRejectedById(){
		rejectedApply = rejectedApplyService.find(rejectedApply.getRejected_apply_id());
		if(rejectedApply!=null)
			return SUCCESS;
		else
			return "input";
	}
	public RejectedApplyService getRejectedApplyService() {
		return rejectedApplyService;
	}

	public void setRejectedApplyService(RejectedApplyService rejectedApplyService) {
		this.rejectedApplyService = rejectedApplyService;
	}

	public RejectedApply getRejectedApply() {
		return rejectedApply;
	}

	public void setRejectedApply(RejectedApply rejectedApply) {
		this.rejectedApply = rejectedApply;
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
	public Long getHasRecord() {
		return hasRecord;
	}
	public void setHasRecord(Long hasRecord) {
		this.hasRecord = hasRecord;
	}
	public List<RejectedApply> getRecord_l() {
		return Record_l;
	}
	public void setRecord_l(List<RejectedApply> record_l) {
		Record_l = record_l;
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}
	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public String getParm() {
		return parm;
	}
	public void setParm(String parm) {
		this.parm = parm;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isClear() {
		return clear;
	}
	public void setClear(boolean clear) {
		this.clear = clear;
	}
}
