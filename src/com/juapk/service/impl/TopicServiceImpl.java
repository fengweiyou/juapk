package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.TopicDAO;
import com.juapk.domain.Topic;
import com.juapk.frame.GlobalConstants;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.TopicService;

/**
 * 项目名称：juapk
 * 类名称：TopicService
 * 类描述：专题数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TopicServiceImpl implements TopicService {

	private TopicDAO topicDAO;
	
	public void setTopicDAO(TopicDAO TopicDAO) {
		this.topicDAO = TopicDAO;
	}
	
	@Override
	public void deleteTopicById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTopicCountByWhere(String where) throws BaseException {
		return topicDAO.getTopicCountByWhere(where);
	}

	@Override
	public List<Topic> getTopicListByQueryItem(QueryItem queryItem) throws BaseException {
		return topicDAO.getTopicListByQueryItem(queryItem);
	}

	/**
	 * 查询所有专题记录
	 * 
	 * @return List<Topic>
	 * 				专题记录
	 * @throws BaseException
	 */
	@Override
	public List<Topic> getAllTopicList() throws BaseException {
		return topicDAO.getTopicListByWhere("where state = " + GlobalConstants.TOPIC_STATE_ON);
	}
	
	/**
	 * 根据 topic_id 查询专题记录
	 * 
	 * @param topic_id
	 * 				专题 ID
	 * @return Topic
	 * 				专题记录
	 * @throws BaseException
	 */
	@Override
	public Topic getTopicListByTopicId(String topic_id) throws BaseException {
		return topicDAO.getTopicByWhere(" where topic_id = " + topic_id);
	}
	@Override
	public List<Topic> getTopicListByWhere(String where) throws BaseException {
		return topicDAO.getTopicListByWhere(where);
	}

	@Override
	public void insertTopic(Topic topic) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public Topic getTopicByWhere(String where) throws BaseException {
		return topicDAO.getTopicByWhere(where);
	}

	@Override
	public void updateTopic(Topic topic) throws BaseException {
		// TODO Auto-generated method stub

	}

}
