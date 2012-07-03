package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.SoftSortDAO;
import com.juapk.domain.SoftSort;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：SoftSortDAOImpl
 * 类描述：软件类型数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftSortDAOImpl extends IBatisEntityDao<SoftSort> implements SoftSortDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(SoftSortDAOImpl.class);
	private static final String GET_SOFTSORT_BY_WHERE = "getSoftSortByWhere";
	private static final String GET_SOFTSORT_BY_QUERYITEM = "getSoftSortByQueryItem";
	private static final String GET_SOFTSORT_COUNT_BY_WHERE = "getSoftSortCountByWhere";

	/**
	 * 新增软件类别信息
	 * 
	 * @param softSort
	 * 				软件类别
	 * @throws BaseException
	 */
	@Override
	public void insertSoftSort(SoftSort softSort) throws BaseException {
		try {
			insert(softSort);
		} catch (SQLException e) {
			LOGGER.error("新增软件类别信息失败.");
		}
	}

	/**
	 * 根据id删除软件类别信息
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */
	@Override
	public void deleteSoftSortById(String id) throws BaseException {
		try {
			removeById(id);
		} catch (SQLException e) {
			LOGGER.error("删除软件类别失败" + e.getMessage());
		}
	}
	
	@Override
	public SoftSort getSoftSortById(Integer id) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSoftSort(SoftSort softSort) throws BaseException {
		// TODO Auto-generated method stub

	}

	/**
	 * 查询满足 where 条件的软件类别记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<SoftSort> 软件类别记录
	 * @throws BaseException
	 */
	@Override
	public List<SoftSort> getSoftSortListByWhere(String where)
			throws BaseException {
		List<SoftSort> softSortList = null;
		try {
			softSortList = findByWhere(GET_SOFTSORT_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的软件类别记录失败."+e.getMessage());
		}
		return softSortList;
	}

	/**
	 * 查询满足 where 条件的软件类别数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 软件类别数量
	 * @throws BaseException
	 */
	@Override
	public int getSoftSortCountByWhere(String where) throws BaseException {
		int toatlSize = 0;
		try {
			toatlSize = getCountByWhere(GET_SOFTSORT_COUNT_BY_WHERE, where);
		} catch (SQLException e) {
			LOGGER.error("查询满足 where 条件的软件类别数量失败."+e.getMessage());
		}
		return toatlSize;
	}

	/**
	 * 查询满足 QueryItem 条件的软件类别记录
	 * 
	 * @param queryItem
	 *            SQL QueryItem 查询条件
	 * @return List<SoftSort> 软件类别记录
	 * @throws BaseException
	 */
	@Override
	public List<SoftSort> getSoftSortListByQueryItem(QueryItem queryItem)
			throws BaseException {
		List<SoftSort> softSortList = null;
		try {
			softSortList = getListByQueryItem(GET_SOFTSORT_BY_QUERYITEM,
					queryItem);
		} catch (SQLException e) {
			LOGGER.error("查询满足 QueryItem 条件的软件类别记录失败."+e.getMessage());
		}
		return softSortList;
	}

}
