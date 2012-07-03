package com.juapk.service;

import java.util.List;

import com.juapk.domain.Topic;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TopicService
 * 类描述：专题数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TopicService {
	
	void insertTopic(Topic topic) throws BaseException;

	void updateTopic(Topic topic) throws BaseException;

	void deleteTopicById(int id) throws BaseException;

	Topic getTopicByWhere(String where) throws BaseException;
	
	List<Topic> getTopicListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 查询所有专题记录
	 * 
	 * @return List<Topic>
	 * 				专题记录
	 * @throws BaseException
	 */
	List<Topic> getAllTopicList() throws BaseException;
	
	
	/**
	 * 根据 topic_id 查询专题记录
	 * 
	 * @param topic_id
	 * 				专题 ID
	 * @return Topic
	 * 				专题记录
	 * @throws BaseException
	 */
	Topic getTopicListByTopicId(String topic_id) throws BaseException;
	
	List<Topic> getTopicListByWhere(String where) throws BaseException;
	
	int getTopicCountByWhere(String where) throws BaseException;
	
}