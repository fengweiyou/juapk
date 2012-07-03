package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.TopicSoftDAO;
import com.juapk.domain.TopicSoft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.TopicSoftService;

/**
 * 项目名称：juapk
 * 类名称：TopicSoftService
 * 类描述：专题软件数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TopicSoftServiceImpl implements TopicSoftService {

	private TopicSoftDAO topicSoftDAO;

	public void setTopicSoftDAO(TopicSoftDAO topicSoftDAO) {
		this.topicSoftDAO = topicSoftDAO;
	}

	@Override
	public void insertTopicSoftSoft(TopicSoft topicSoft)
			throws BaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTopicSoft(TopicSoft topicSoft) throws BaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTopicSoftById(int id) throws BaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TopicSoft getTopicSoftByWhere(String where) throws BaseException {
		return topicSoftDAO.getTopicSoftByWhere(where);
	}

	@Override
	public List<TopicSoft> getTopicSoftListByQueryItem(QueryItem queryItem) throws BaseException {
		return topicSoftDAO.getTopicSoftListByQueryItem(queryItem);
	}

	@Override
	public List<TopicSoft> getTopicSoftListByWhere(String where) throws BaseException {
		return topicSoftDAO.getTopicSoftListByWhere(where);
	}

	@Override
	public int getTopicSoftCountByWhere(String where) throws BaseException {
		return topicSoftDAO.getTopicSoftCountByWhere(where);
	}

}
