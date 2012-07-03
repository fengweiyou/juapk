package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.TopicSoftDAO;
import com.juapk.domain.TopicSoft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：TopicSoftDAOImpl
 * 类描述：专题软件数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TopicSoftDAOImpl extends IBatisEntityDao<TopicSoft> implements TopicSoftDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(TopicSoftDAOImpl.class);
	private static final String GET_TOPICSOFT_BY_WHERE = "getTopicSoftByWhere";
	private static final String GET_TOPICSOFT_COUNT_BY_WHERE = "getTopicSoftCountByWhere";
	private static final String GET_TOPICSOFT_BY_QUERYITEM = "getTopicSoftByQueryItem";
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
	public TopicSoft getTopicSoftByWhere(String where)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 查询满足 QueryItem 条件的专题软件记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<TopicSoft> 专题软件记录
	 * @throws BaseException
	 */
	@Override
	public List<TopicSoft> getTopicSoftListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<TopicSoft> topicSoftList = null;
		try {
			topicSoftList = getListByQueryItem(GET_TOPICSOFT_BY_QUERYITEM, queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的专题软件记录失败."+e.getMessage());
		}
		return topicSoftList;
	}

	/**
	 * 查询满足 where 条件的专题软件记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<TopicSoft> 专题软件记录
	 * @throws BaseException
	 */
	@Override
	public List<TopicSoft> getTopicSoftListByWhere(String where)
			throws BaseException {
		List<TopicSoft> topicSoftList = null;
		try {
			topicSoftList = findByWhere(GET_TOPICSOFT_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的专题软件记录失败."+e.getMessage());
		}
		return topicSoftList;
	}

	/**
	 * 查询满足 where 条件的专题软件数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 专题软件数量
	 * @throws BaseException
	 */
	@Override
	public int getTopicSoftCountByWhere(String where) throws BaseException {
		Integer toatlSize = 0;
		try {
			toatlSize = getCountByWhere(GET_TOPICSOFT_COUNT_BY_WHERE,where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的专题软件数量失败."+e.getMessage());
		}
		return toatlSize;
	}

}
