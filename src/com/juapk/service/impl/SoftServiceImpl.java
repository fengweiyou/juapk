package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.SoftDAO;
import com.juapk.domain.Soft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.SoftService;

/**
 * 项目名称：juapk
 * 类名称：SoftService
 * 类描述：软件数据访问服务实现类 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class SoftServiceImpl implements SoftService {
	private SoftDAO softDAO;
	
	public void setSoftDAO(SoftDAO softDAO) {
		this.softDAO = softDAO;
	}

	/**
	 * 新增软件信息
	 * 
	 * @param soft
	 * 			软件
	 * @throws BaseException
	 */
	@Override
	public void insertSoft(Soft soft) throws BaseException {
		softDAO.insertSoft(soft);
	}

	@Override
	public void deleteSoftById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 根据关键字段 ID 获得软件对象
	 * @param id 
	 * 			软件关键字段 ID
	 * @return Soft 软件记录
	 * @exception BaseException
	 */
	@Override
	public Soft getSoftById(Integer id) throws BaseException {
		return softDAO.getSoftByWhere(" WHERE soft_id=" + id);
	}

	@Override
	public Soft getSoftByWhere(String where) throws BaseException {
		return softDAO.getSoftByWhere(where);
	}
	
	@Override
	public void updateSoft(Soft soft) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getSoftCountByWhere(String where) throws BaseException {
		return softDAO.getSoftCountByWhere(where);
	}

	@Override
	public List<Soft> getSoftListByQueryItem(QueryItem queryItem) throws BaseException {
		return softDAO.getSoftListByQueryItem(queryItem);
	}

	@Override
	public List<Soft> getSoftListByWhere(String where) throws BaseException {
		return softDAO.getSoftListByWhere(where);
	}
	
	/**
	 * 根据 topic_id 查询专题软件记录
	 * 
	 * @param topic_id
	 * 				专题 ID
	 * @return List<Soft>
	 * 				软件记录
	 * @throws BaseException
	 */
	public List<Soft> getSoftTopicListByTopicId(String topic_id) throws BaseException{
		return softDAO.getSoftTopicListByWhere(" where b.topic_id = "+topic_id);
	}
	
	/**
	 * 根据 type 查询软件排行记录
	 * 
	 * @param type
	 * 				类型
	 * @return List<Soft>
	 * 				软件记录
	 * @throws BaseException
	 */
	@Override
	public List<Soft> getSoftTopListByType(int type) throws BaseException {
		return softDAO.getSoftTopListByType(type);
	}

	@Override
	public List<Soft> getSoftCommendListByWhere(String where) throws BaseException {
		return softDAO.getSoftCommendListByWhere(where);
	}

	@Override
	public List<Soft> getSoftCommendListByQueryItem(QueryItem queryItem) throws BaseException {
		return softDAO.getSoftCommendListByQueryItem(queryItem);
	}
	
	@Override
	public List<Soft> getSoftTopicListByWhere(String where) throws BaseException {
		return softDAO.getSoftTopicListByWhere(where);
	}
	
	@Override
	public List<Soft> getSoftTopicListByQueryItem(QueryItem queryItem) throws BaseException {
		return softDAO.getSoftTopicListByQueryItem(queryItem);
	}

}
