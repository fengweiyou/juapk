package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.SoftCommendDAO;
import com.juapk.domain.SoftCommend;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：SoftCommendDAOImpl
 * 类描述：推荐软件数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftCommendDAOImpl extends IBatisEntityDao<SoftCommend> implements SoftCommendDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(SoftCommendDAOImpl.class);
	private static final String GET_SOFTCOMMEND_COUNT_BY_WHERE = "getSoftCommendCountByWhere";
	
	@Override
	public void deleteSoftCommendById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public SoftCommend getSoftCommendByWhere(String where)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询满足 where 条件的推荐软件数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 推荐软件数量
	 * @throws BaseException
	 */
	@Override
	public int getSoftCommendCountByWhere(String where) throws BaseException {
		int toatlSize = 0;
		try {
			toatlSize = getCountByWhere(GET_SOFTCOMMEND_COUNT_BY_WHERE,where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的推荐软件数量失败."+e.getMessage());
		}
		return toatlSize;
	}

	@Override
	public List<SoftCommend> getSoftCommendListByQueryItem(QueryItem queryItem)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SoftCommend> getSoftCommendListByWhere(String where)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertSoftCommend(SoftCommend softCommend)
			throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateSoftCommend(SoftCommend softCommend)
			throws BaseException {
		// TODO Auto-generated method stub

	}

}
