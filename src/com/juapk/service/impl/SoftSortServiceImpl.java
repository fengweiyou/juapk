package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.SoftSortDAO;
import com.juapk.domain.SoftSort;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.util.DBUUID;
import com.juapk.service.SoftSortService;

/**
 * 项目名称：juapk
 * 类名称：SoftSortService
 * 类描述：软件类型数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftSortServiceImpl implements SoftSortService {
	private SoftSortDAO softSortDAO;

	public void setSoftSortDAO(SoftSortDAO softSortDAO) {
		this.softSortDAO = softSortDAO;
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
		softSortDAO.deleteSoftSortById(id);
	}

	@Override
	public List<SoftSort> getSoftSortListByWhere(String where) throws BaseException {
		return softSortDAO.getSoftSortListByWhere(" where soft_type = " + where);
	}

	/**
	 * 新增软件类别信息
	 * 
	 * @param softSort
	 * 				软件类别
	 * @throws BaseException
	 */
	@Override
	public void insertSoftSort(SoftSort softSort) throws BaseException {
		softSort.setSoft_sort_id(DBUUID.getID());	// 软件类别 ID
		softSortDAO.insertSoftSort(softSort);
	}

	@Override
	public SoftSort getSoftSortById(Integer id) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSoftSort(SoftSort SoftSort) throws BaseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSoftSortCountByWhere(String where) throws BaseException {
		return softSortDAO.getSoftSortCountByWhere(where);
	}

	@Override
	public List<SoftSort> getSoftSortListByQueryItem(QueryItem queryItem)
			throws BaseException {
		return softSortDAO.getSoftSortListByQueryItem(queryItem);
	}

}
