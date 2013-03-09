package com.bookshop.action;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bookshop.entity.Promotion;
import com.bookshop.entity.Staff;
import com.bookshop.service.PromotionService;
import com.bookshop.util.PageUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * �Żݻ��ϢAction��
 * @author Winds
 *
 */
@SuppressWarnings("serial")
public class PromotionAction extends ActionSupport {
	@Resource
	private PromotionService promotionService;
	private Promotion promotion;
	private Long hasPromotion; // ��ݵ�����
	private int page; // ��ǰҳ
	private int hasPages; // ҳ��
	private int perFolioAmount; // ÿҳ��ݵ�����
	private List<Integer> page_l;
	private List<Promotion> promotion_l;
	private boolean isLike;
	private int status; //0:û���� 1���ѹ���
	private String promotion_catagorys;  //�Żݵ�ͼ�����
	/**
	 * ��ҳ��ȡ�Ż���Ϣ
	 * @return
	 */
	public String showPromotion_by_page() {
		try{
		perFolioAmount = 2; // ÿҳ��ʾ����
		this.hasPromotion = promotionService.hasNumbers(status); // ��ȡ�������
		hasPages = PageUtil.findAllPages(perFolioAmount, hasPromotion);; // ��ȡҳ��
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
		// ��ȡ��ǰҳ�����
		this.promotion_l = (List<Promotion>) promotionService.show_by_page(page, perFolioAmount,status);
		if(status==0){
			return "success1";
		}else{
			return "success2";
		}	
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	
	/**
	 * ����Ż���Ϣ
	 * @return
	 */
	public String addPromotion(){
		try{
			if(promotionService.add(promotion)){
				this.status=0;
				return "success";
			}else{
				return "input";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}

	/**
	 * ɾ���Ż�
	 */
	public void deletePromotion(){
		try{
			String flag="input";
			if(promotionService.delete(promotion.getPromotion_id())){				
				flag="success";
			}					
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			// ֱ��������Ӧ������
			out.print(flag);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡû���ڵ��Ż���Ϣ
	 */
	public String gainPromotion(){
		try{
			this.promotion=promotionService.find(promotion.getPromotion_id());
			if(promotion!=null){
				this.promotion_catagorys=promotionService.gainCatagory_l(promotion.getPromotion_catagorys());
				return "success";
			}else{
				return "input";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	
	/**
	 * �޸�δ���ڵ��Ż���Ϣ
	 */
	public String updatePromotion(){
		try{			
			if(promotionService.update(promotion)){
				return "success";
			}else{
				return "input";
			}
		}catch(Exception e){
			e.printStackTrace();
			return "input";
		}
	}
	/**
	 * ɾ��δ�����Ż�
	 */
	public void findNotExpirePromotion_by_time(){
		try{
			String flag="input";
			if(promotionService.findNotExpirePromotion_by_time(promotion.getPromotion_id())){
				promotionService.delete(promotion.getPromotion_id());
				flag="success";
			}					
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			// ֱ��������Ӧ������
			out.print(flag);
			out.flush();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		clearFieldErrors(); clearActionErrors(); clearMessages();
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Long getHasPromotion() {
		return hasPromotion;
	}

	public void setHasPromotion(Long hasPromotion) {
		this.hasPromotion = hasPromotion;
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

	public List<Promotion> getPromotion_l() {
		return promotion_l;
	}

	public void setPromotion_l(List<Promotion> promotion_l) {
		this.promotion_l = promotion_l;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean isLike) {
		this.isLike = isLike;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public void clearActionErrors() {
		// TODO Auto-generated method stub
		super.clearActionErrors();
	}

	public String getPromotion_catagorys() {
		return promotion_catagorys;
	}

	public void setPromotion_catagorys(String promotion_catagorys) {
		this.promotion_catagorys = promotion_catagorys;
	}
}
