package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.TopicDAO;
import com.juapk.domain.Topic;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：TopicDAOImpl
 * 类描述：专题数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TopicDAOImpl extends IBatisEntityDao<Topic> implements TopicDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(TopicDAOImpl.class);
	private static final String GET_TOPIC_BY_WHERE = "getTopicByWhere";
	private static final String GET_TOPIC_BY_QUERYITEM = "getTopicByQueryItem";
	private static final String GET_TOPIC_COUNT_BY_WHERE = "getTopicCountByWhere";

	@Override
	public void insertTopic(Topic topic) throws BaseException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateTopic(Topic topic) throws BaseException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void deleteTopicById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	/**
	 * 查询满足 where 条件的专题对象
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return Topic 专题对象
	 * @throws BaseException
	 */
	@Override
	public Topic getTopicByWhere(String where) throws BaseException {
		Topic Topic = null;
		try {
			Topic = (Topic) findUniqueByWhere(GET_TOPIC_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的专题对象."+e.getMessage());
		}
		return Topic;
	}

	/**
	 * 查询满足 where 条件的专题记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Topic> 专题记录
	 * @throws BaseException
	 */
	@Override
	public List<Topic> getTopicListByWhere(String where) throws BaseException {
		List<Topic> TopicList = null;
		try {
			TopicList = findByWhere(GET_TOPIC_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的专题记录失败."+e.getMessage());
		}
		return TopicList;
	}

	/**
	 * 查询满足 where 条件的专题数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 专题数量
	 * @throws BaseException
	 */
	@Override
	public int getTopicCountByWhere(String where) throws BaseException {
		Integer toatlSize = 0;
		try {
			toatlSize = (Integer)getCountByWhere(GET_TOPIC_COUNT_BY_WHERE,where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的专题数量失败."+e.getMessage());
		}
		return toatlSize;
	}

	/**
	 * 查询满足 QueryItem 条件的专题记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<Topic> 专题记录
	 * @throws BaseException
	 */
	@Override
	public List<Topic> getTopicListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<Topic> topicList = null;
		try {
			topicList = getListByQueryItem(GET_TOPIC_BY_QUERYITEM,queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的专题记录失败."+e.getMessage());
		}
		return topicList;
	}

}
