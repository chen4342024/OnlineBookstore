package com.bookshop.service;

import java.util.List;

/**
 * 评论信息Service层接口
 * @author Winds
 *
 */
public interface CommentService extends MyServiceParent{
	public List<Integer> findStarList(String book_l);
	
}
