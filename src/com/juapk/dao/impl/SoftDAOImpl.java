package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.SoftDAO;
import com.juapk.domain.Soft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：SoftDAOImpl
 * 类描述：软件数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.20
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftDAOImpl extends IBatisEntityDao<Soft> implements SoftDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(SoftDAOImpl.class);
	private static final String GET_SOFT_BY_QUERYITEM = "getSoftByQueryItem";
	private static final String GET_SOFT_BY_WHERE = "getSoftByWhere";
	// Top软件列表
	private static final String GET_SOFTTOP_LIST_BY_TYPE = "getSoftTopListByType";
	// 推荐软件记录
	private static final String GET_SOFTCOMMEND_LIST_BY_WHERE = "getSoftCommendListByWhere";
	private static final String GET_SOFTCOMMEND_LIST_BY_QUERYITEM = "getSoftCommendListByQueryItem";
	// Topic专题软件列表
	private static final String GET_SOFTTOPIC_LIST_BY_WHERE = "getSoftTopicListByWhere";
	private static final String GET_TOPICSOFT_LIST_BY_QUERYITEM = "getSoftTopicListByQueryItem";
	private static final String GET_SOFT_COUNT_BY_WHERE = "getSoftCountByWhere";

	/**
	 * 新增软件信息
	 * 
	 * @param soft
	 * 			软件
	 * @throws BaseException
	 */
	@Override
	public void insertSoft(Soft soft) throws BaseException {
		try {
			insert(soft);
		} catch (SQLException e) {
			LOGGER.error("新增软件信息失败."+e.getMessage());
		}
	}

	@Override
	public void deleteSoftById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void updateSoft(Soft soft) throws BaseException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 查询满足 where 条件的软件对象
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return Soft 软件记录
	 * @throws BaseException
	 */
	@Override
	public Soft getSoftByWhere(String where) throws BaseException {
		Soft Soft = null;
		try {
			Soft = (Soft)this.getSqlMapClient().queryForObject(
					getMappedSQLID(GET_SOFT_BY_WHERE), where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的软件对象失败."+e.getMessage());
		}
		return Soft;
	}


	/**
	 * 查询满足 where 条件的软件数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 软件数量
	 * @throws BaseException
	 */
	@Override
	public int getSoftCountByWhere(String where) throws BaseException {
		int softCount = 0;
		try {
			softCount = getCountByWhere(GET_SOFT_COUNT_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的软件数量失败."+e.getMessage());
		}
		return softCount;
	}

	/**
	 * 查询满足 QueryItem 条件的软件记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<Soft> 软件记录
	 * @throws BaseException
	 */
	@Override
	public List<Soft> getSoftListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<Soft> SoftList = null;
		try {
			SoftList = getListByQueryItem(GET_SOFT_BY_QUERYITEM, queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的软件记录失败."+e.getMessage());
		}
		return SoftList;
	}

	/**
	 * 查询满足 where 条件的软件记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Soft> 软件记录
	 */
	@Override
	public List<Soft> getSoftListByWhere(String where) throws BaseException {
		List<Soft> SoftList = null;
		try {
			SoftList = findByWhere(GET_SOFT_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的软件记录失败."+e.getMessage());
		}
		return SoftList;
	}

	/**
	 * 查询满足 type 条件的Top软件排行记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Soft> Top 软件排行记录
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Soft> getSoftTopListByType(int type) throws BaseException {
		List<Soft> topSoftList = null;
		try {
			topSoftList = getSqlMapClient().queryForList(
					getMappedSQLID(GET_SOFTTOP_LIST_BY_TYPE), type);
		} catch (SQLException e) {
			LOGGER.error("查询满足 type 条件的Top软件排行记录失败."+e.getMessage());
		}
		return topSoftList;
	}

	/**
	 * 查询满足 where 条件的推荐软件记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Soft> 推荐软件记录
	 */
	@Override
	public List<Soft> getSoftCommendListByWhere(String where)
			throws BaseException {
		List<Soft> softCommendList = null;
		try {
			softCommendList = findByWhere(GET_SOFTCOMMEND_LIST_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的推荐软件记录失败."+e.getMessage());
		}
		return softCommendList;
	}

	/**
	 * 查询满足 QueryItem 条件的推荐软件记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<Soft> 推荐软件记录
	 * @throws BaseException
	 */
	@Override
	public List<Soft> getSoftCommendListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<Soft> softCommendList = null;
		try {
			softCommendList = getListByQueryItem(
					GET_SOFTCOMMEND_LIST_BY_QUERYITEM, queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的推荐软件记录失败."+e.getMessage());
		}
		return softCommendList;
	}

	/**
	 * 查询满足 where 条件的Topic专题软件记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<Soft> Topic专题软件记录
	 */
	@Override
	public List<Soft> getSoftTopicListByWhere(String where)
			throws BaseException {
		List<Soft> topicSoftList = null;
		try {
			topicSoftList = findByWhere(GET_SOFTTOPIC_LIST_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的Topic专题软件记录失败."+e.getMessage());
		}
		return topicSoftList;
	}

	/**
	 * 查询满足 QueryItem 条件的Topic专题软件记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<Soft> Topic专题软件记录
	 * @throws BaseException
	 */
	@Override
	public List<Soft> getSoftTopicListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<Soft> topicSoftList = null;
		try {
			topicSoftList = getListByQueryItem(GET_TOPICSOFT_LIST_BY_QUERYITEM,
					queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的Topic专题软件记录失败."+e.getMessage());
		}
		return topicSoftList;
	}

}