package com.juapk.dao;

import java.util.List;

import com.juapk.domain.Topic;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TopicDAO
 * 类描述：专题数据访问对象 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TopicDAO {
	
	void insertTopic(Topic topic) throws BaseException;

	void updateTopic(Topic topic) throws BaseException;

	void deleteTopicById(int id) throws BaseException;

	/**
	 * 查询满足 where 条件的专题对象
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return Topic 专题对象
	 * @throws BaseException
	 */
	Topic getTopicByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的专题记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Topic> 专题记录
	 * @throws BaseException
	 */
	List<Topic> getTopicListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的专题数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 专题数量
	 * @throws BaseException
	 */
	int getTopicCountByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的专题记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<Topic> 专题记录
	 * @throws BaseException
	 */
	List<Topic> getTopicListByQueryItem(QueryItem queryItem) throws BaseException;

}