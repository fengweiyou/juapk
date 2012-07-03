package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.SoftTopDAO;
import com.juapk.domain.SoftTop;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：SoftTopDAOImpl
 * 类描述：软件排行数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftTopDAOImpl extends IBatisEntityDao<SoftTop> implements SoftTopDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(SoftTopDAOImpl.class);
	private static final String GET_SOFTTOP_BY_WHERE = "getSoftTopByWhere";

	@Override
	public void deleteSoftTopById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSoftTopCountByWhere(String where) throws BaseException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SoftTop> getSoftTopListByQueryItem(QueryItem queryItem)
			throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 查询满足 where 条件的软件排行记录
	 * 
	 * @param where
	 *            	SQL WHERE 查询条件
	 * @return List<SoftTop>
	 * 				软件排行记录
	 * @throws BaseException
	 */
	@Override
	public List<SoftTop> getSoftTopListByWhere(String where) throws BaseException {
		List<SoftTop> softTopList = null;
		try {
			softTopList = findByWhere(GET_SOFTTOP_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 WHERE 条件的软件排行记录失败."+e.getMessage());
		}
		return softTopList;
	}

	@Override
	public void insertSoftTop(SoftTop softTop) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public SoftTop getSoftTopById(Integer id) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSoftTop(SoftTop softTop) throws BaseException {
		// TODO Auto-generated method stub

	}

}
