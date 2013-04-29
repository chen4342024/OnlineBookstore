package com.bookshop.service;

import java.util.List;

public interface MyServiceParent {
	/*
	 * 
	 * 查询总个数
	 */
	public Long hasNumbers(String entityName) ;

	public Long hasNumbers(String entityName, int status) ;

	public Long hasNumbers(String entityName, String[] paramName, String[] value) ;

	public Long hasNumbers(String entityName, String[] paramName,
			String[] value, boolean isLike) ;
  /**
   * 根据时间段搜查时的分页显示
   */
  public Long hasNumbers(String entityName, String timeParam, String begin,
      String end, String parm, String value) ;
	/***
	 * 
	 * 查询总页数
	 */
	public int findPages(int perFolioAmount, String entityName);

	public int findPages(int perFolioAmount, String entityName, int status) ;

	// 根据页数遍历
	public List<?> show_by_page(int page, int perFolioAmount, String entityName) ;

	public List<?> show_by_page(int page, int perFolioAmount,
			String entityName, int status) ;

	public List<?> show_by_page(int page, int perFolioAmount,
			String entityName, String[] paramName, String[] value,
			boolean isLike) ;


	public List<?> show_by_page(int page, int perFolioAmount,
			String entityName, String timeParam, String begin, String end,
			String parm, String value) ;

}
