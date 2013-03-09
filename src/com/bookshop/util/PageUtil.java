package com.bookshop.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil {
	//��ҳ���Ƴ�List<>,����ҳ����ת������
	public static List<Integer> getPageList(Integer hasPage){
		List<Integer> page_l = new ArrayList<Integer>();
		if(hasPage != null && hasPage >0){
			for(int i= 1;i <= hasPage;i++){
				page_l.add(i);
			}
		} 
		return page_l;
	}
	//������ҳ��
	public static int findAllPages(int perFolioAmount,Long has){
		int pagenum;
		int num = has.intValue();
		pagenum = num/perFolioAmount;
		num = num%perFolioAmount;
		if(num>0){
			pagenum++;
		}
		return pagenum;
	}
}
