package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.SoftCommendDAO;
import com.juapk.domain.SoftCommend;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftCommendService;

/**
 * 项目名称：juapk
 * 类名称：SoftCommendService
 * 类描述：推荐软件数据访问服务实现类
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftCommendServiceImpl implements SoftCommendService {
	private SoftCommendDAO softCommendDAO;
	
	public void setSoftCommendDAO(SoftCommendDAO softCommendDAO) {
		this.softCommendDAO = softCommendDAO;
	}

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

	@Override
	public int getSoftCommendCountByWhere(String where) throws BaseException {
		return softCommendDAO.getSoftCommendCountByWhere(where);
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
