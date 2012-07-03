package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.SoftTopDAO;
import com.juapk.domain.SoftTop;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftTopService;

/**
 * 项目名称：juapk
 * 类名称：SoftTopService
 * 类描述：软件排行数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftTopServiceIpml implements SoftTopService {

	private SoftTopDAO softTopDAO;
	
	public void setSoftTopDAO(SoftTopDAO softTopDAO) {
		this.softTopDAO = softTopDAO;
	}

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
	public List<SoftTop> getSoftTopListByQueryItem(QueryItem queryItem) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SoftTop> getSoftTopListByWhere(String where) throws BaseException {
		return softTopDAO.getSoftTopListByWhere(where);
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
