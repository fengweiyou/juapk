package com.juapk.dao;

import java.util.List;

import com.juapk.domain.TopicSoft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TopicSoftDAO
 * 类描述：专题软件数据访问对象 
 * 创建人：Administrator
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TopicSoftDAO {
	
	void insertTopicSoftSoft(TopicSoft topicSoft) throws BaseException;

	void updateTopicSoft(TopicSoft topicSoft) throws BaseException;

	void deleteTopicSoftById(int id) throws BaseException;

	TopicSoft getTopicSoftByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的专题软件记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<TopicSoft> 专题软件记录
	 * @throws BaseException
	 */
	List<TopicSoft> getTopicSoftListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 查询满足 where 条件的专题软件记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<TopicSoft> 专题软件记录
	 * @throws BaseException
	 */
	List<TopicSoft> getTopicSoftListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的专题软件数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 专题软件数量
	 * @throws BaseException
	 */
	int getTopicSoftCountByWhere(String where) throws BaseException;
	
}